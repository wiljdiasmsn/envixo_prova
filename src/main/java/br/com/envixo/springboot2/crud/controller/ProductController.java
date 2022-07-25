package br.com.envixo.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import br.com.envixo.springboot2.crud.exception.ResourceNotFoundException;
import br.com.envixo.springboot2.crud.model.Products;
import br.com.envixo.springboot2.crud.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	private ProductsRepository productsRepository;

	@GetMapping("/products")
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Products products = productsRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Products not found for this id :: " + productId));
		return ResponseEntity.ok().body(products);
	}

	@GetMapping("/products/enabled/{enabled}")
	public List<Products> getProductByEnabled(@PathVariable(value = "enabled") Boolean enabled)
			throws ResourceNotFoundException {

		return productsRepository.findByEnabled(enabled);
	}

	@GetMapping("/products/title/{title}")
	public List<Products> getProductByTitle(@PathVariable(value = "title") String title)
			throws ResourceNotFoundException {

		return productsRepository.findByTitleContaining(title);
	}

	@PostMapping("/products")
	public Products createProduct(@Valid @RequestBody Products products) {
		return productsRepository.save(products);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProduct(@PathVariable(value = "id") Long productId,
												  @Valid @RequestBody Products productsDetails) throws ResourceNotFoundException {
		Products products = productsRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Products not found for this id :: " + productId));

		products.setId(productsDetails.getId());
		products.setDescription(productsDetails.getDescription());
		products.setTitle(productsDetails.getTitle());
		final Products updatedProducts = productsRepository.save(products);
		return ResponseEntity.ok(updatedProducts);
	}

	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
			throws ResourceNotFoundException {
		Products products = productsRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Products not found for this id :: " + productId));

		productsRepository.delete(products);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
