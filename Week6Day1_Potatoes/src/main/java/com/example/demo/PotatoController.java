package com.example.demo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/potato")
public class PotatoController {

	ArrayList<Potato> potatoes = new ArrayList<Potato>();
	AtomicInteger at = new AtomicInteger(1);
	
	@GetMapping()
	public ArrayList<Potato> getPotatoes(){
		return potatoes;
	}
	
	@PostMapping()
	public Potato createPotato(@RequestBody Potato potato) {
		potato.setId(at.getAndIncrement());
		potatoes.add(potato);
		return potato;
	}
	
	@DeleteMapping("/{id}")
	public void deletePotato(@PathVariable("id")int id) {
		Potato removePotato = null;
		for(Potato potato:potatoes) {
			if(potato.getId() == id) {
				removePotato = potato;
			}
				
		}
		potatoes.remove(removePotato);
	}
}
