package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/shoppinglist")
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
	

}
