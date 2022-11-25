package br.edu.fatecfranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecfranca.model.DogEntity;
import br.edu.fatecfranca.model.DogRepository;

@RestController
@RequestMapping("/api/dog")
public class DogController {
	// injeção de dependência
	@Autowired
	DogRepository injecao;
	
	@GetMapping // select no banco de dados
	public List<DogEntity> getDog(){
		
		return injecao.findAll();
	
	}
	
	@PostMapping // insert no banco de dados
	public DogEntity addDog(@RequestBody DogEntity dogEntity) {
		
		return injecao.save(dogEntity);
	
	}
	
	@DeleteMapping("/{id}") // delete no banco de dados
	public String removeDog(@PathVariable Long id) {
	
		injecao.deleteById(id);
		return "Remoção realizada com sucesso";
	
	}
	
	@PutMapping // update no banco de dados
	public DogEntity updateDogEntity(@RequestBody DogEntity dogEntity) {
		// o parâmetro timeFutebol virá com id
		
		return injecao.save(dogEntity); // vai atualizar pois o objeto tem id
	}
	
	
}
