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
@RequestMapping("/buttons")
public class ButtonController {
	private ArrayList<Button>buttons = new ArrayList<Button>(); 
	private AtomicInteger at = new AtomicInteger(1);
	
	@GetMapping()
	public ArrayList <Button> getButtons(){
		return buttons;
	}

	@PostMapping()
	public int CreateButton(@RequestBody Button button) {
		button.setId(at.getAndIncrement());
		buttons.add(button);
		return button.getId();
	}

	@DeleteMapping("/{id}")
	public void deleteButton(@PathVariable(name="id")int id) {
		Button deleteButton = null;
		for (Button button : buttons) {
			if(button.getId() == id) {
				deleteButton = button;
}
}

	buttons.remove(deleteButton);
	}
	@PutMapping("/{id}")
	public Button updateButton(@PathVariable(name = "id") int id, @RequestBody Button button) {
		for (Button butt : buttons) {
			if (button.getId() ==id) {
				button.setId(button.getId());
				return button;
			}
		}
		return null;	
}
}