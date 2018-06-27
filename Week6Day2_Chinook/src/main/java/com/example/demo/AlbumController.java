package com.example.demo;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	AlbumRepository albumRepository;
	
	@GetMapping
	public List<Album> getAlbum(){
		return albumRepository.findAll();	}

}
