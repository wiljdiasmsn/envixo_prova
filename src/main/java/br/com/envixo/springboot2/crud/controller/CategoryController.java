package br.com.envixo.springboot2.crud.controller;

import br.com.envixo.springboot2.crud.exception.ResourceNotFoundException;
import br.com.envixo.springboot2.crud.model.Categories;
import br.com.envixo.springboot2.crud.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	@Autowired
	private CategoriesRepository categoriesRepository;

	@GetMapping("/categories")
	public List<Categories> getAllCategories() {
		return categoriesRepository.findAll();
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Categories> getCategoryById(@PathVariable(value = "id") Long categoryId)
			throws ResourceNotFoundException {
		Categories categories = categoriesRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));
		return ResponseEntity.ok().body(categories);
	}

	@PostMapping("/categories")
	public Categories createCategory(@Valid @RequestBody Categories category) {
		return categoriesRepository.save(category);
	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<Categories> updateCategory(@PathVariable(value = "id") Long categoryId,
													@Valid @RequestBody Categories categoryDetails) throws ResourceNotFoundException {
		Categories categories = categoriesRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Categories not found for this id :: " + categoryId));

		categories.setId(categoryDetails.getId());
		categories.setDescription(categoryDetails.getDescription());
		categories.setTitle(categoryDetails.getTitle());
		final Categories updatedCategories = categoriesRepository.save(categories);
		return ResponseEntity.ok(updatedCategories);
	}

	@DeleteMapping("/categories/{id}")
	public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId)
			throws ResourceNotFoundException {
		Categories categories = categoriesRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Categories not found for this id :: " + categoryId));

		categoriesRepository.delete(categories);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
