package br.com.envixo.springboot2.crud.controller;

import br.com.envixo.springboot2.crud.exception.ResourceNotFoundException;
import br.com.envixo.springboot2.crud.model.Medias;
import br.com.envixo.springboot2.crud.repository.MediasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MeidaController {
	@Autowired
	private MediasRepository mediasRepository;

	@GetMapping("/medias")
	public List<Medias> getAllMedias() {
		return mediasRepository.findAll();
	}

	@GetMapping("/medias/{id}")
	public ResponseEntity<Medias> getCategoryById(@PathVariable(value = "id") Long mediaId)
			throws ResourceNotFoundException {
		Medias medias = mediasRepository.findById(mediaId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + mediaId));
		return ResponseEntity.ok().body(medias);
	}

	@PostMapping("/medias")
	public Medias createProduct(@Valid @RequestBody Medias media) {
		return mediasRepository.save(media);
	}

	@PutMapping("/medias/{id}")
	public ResponseEntity<Medias> updateCategory(@PathVariable(value = "id") Long mediaId,
													@Valid @RequestBody Medias mediaDetails) throws ResourceNotFoundException {
		Medias medias = mediasRepository.findById(mediaId)
				.orElseThrow(() -> new ResourceNotFoundException("Medias not found for this id :: " + mediaId));

		medias.setId(mediaDetails.getId());
		medias.setDescription(mediaDetails.getDescription());
		medias.setTitle(mediaDetails.getTitle());
		final Medias updatedMedias = mediasRepository.save(medias);
		return ResponseEntity.ok(updatedMedias);
	}

	@DeleteMapping("/medias/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long mediaId)
			throws ResourceNotFoundException {
		Medias medias = mediasRepository.findById(mediaId)
				.orElseThrow(() -> new ResourceNotFoundException("Medias not found for this id :: " + mediaId));

		mediasRepository.delete(medias);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
