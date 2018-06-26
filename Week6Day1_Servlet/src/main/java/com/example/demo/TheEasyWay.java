package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TheEasyWay")


public class TheEasyWay {

	@GetMapping("/{beans}")
	public String easyGet(@PathVariable(name="beans")String beans) {
		return "Easy Get" + beans;
	}
	
}
