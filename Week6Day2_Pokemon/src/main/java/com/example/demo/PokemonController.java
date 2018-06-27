package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	PokemonRepository pokemonRepository;
	
	@GetMapping
	public List<Pokemon> getPokemon(){
		return pokemonRepository.findAll();
	}
	
	@PostMapping()
	public void createPokemon(@RequestBody Pokemon pokemon) {
	
		pokemonRepository.save(pokemon);
	}
	
	@DeleteMapping("/id")
	public void deletePokemon(@PathVariable("id")Integer id) {
		Pokemon foundPokemon = pokemonRepository.findById(id).orElse(null);
		pokemonRepository.delete(foundPokemon);
	}
}
