package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artists")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int artistId;
	private String name;
	public String getName() {
		return name;
	}
	public String setName() {
		return name;
	}
	
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
}
