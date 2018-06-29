package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ShoppingList;
import com.example.demo.models.ShoppingListRepository;



@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/shoppinglist")
public class ShoppingListController {

	@Autowired
	ShoppingListRepository shoppingListRepository;
	
	@GetMapping()
	public List<ShoppingList> getShoppingList(){
		return shoppingListRepository.findAll();
	}
	
	@PostMapping()
	public void createShoppingList(@RequestBody ShoppingList shoppingList) {
		shoppingListRepository.save(shoppingList);
	}
}
