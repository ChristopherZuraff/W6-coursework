package com.example.demo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dino")
public class DinoController {
	
	private ArrayList<Dinosaur> dinos = new ArrayList<Dinosaur>(); 
	private AtomicInteger at = new AtomicInteger(0);
	
	
	@GetMapping()
	public ArrayList<Dinosaur> getDinos(){
		return dinos;
	}
	
	@PostMapping()
	public String createDino(@RequestBody Dinosaur dinosaur) {
		dinosaur.setId(at.getAndIncrement());
		dinos.add(dinosaur);
		return dinosaur.getName();
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteDino(@PathVariable(name="id")int id) {
		Dinosaur deleteDino = null;
		for (Dinosaur dino : dinos) {
			if(dino.getId() == id) {
				deleteDino = dino;
			}
		}
	dinos.remove(deleteDino);
}
	
	@PutMapping("/{id}")
	public Dinosaur updateDino(@PathVariable(name = "id") int id, @RequestBody Dinosaur dinosaur) {
		for (Dinosaur dino : dinos) {
			if (dino.getId() ==id) {
				dino.setName(dinosaur.getName());
				return dino;
			}
		}
		return null;
	}
}