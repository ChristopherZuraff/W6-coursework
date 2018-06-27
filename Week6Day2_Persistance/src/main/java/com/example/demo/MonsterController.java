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
@RequestMapping("/monster")
public class MonsterController {

	@Autowired
	MonsterRepository monsterRepository;
	
	@GetMapping()
	public List<Monster> getMonsters(){
		return monsterRepository.findAll();
	}
	
	@PostMapping()
	public void createMonster(@RequestBody Monster monster) {
	
		monsterRepository.save(monster);
	}
	
	@DeleteMapping("/id")
	public void deleteMonster(@PathVariable("id")Integer id) {
		Monster foundMonster = monsterRepository.findById(id).orElse(null);
		monsterRepository.delete(foundMonster);
	}
}
