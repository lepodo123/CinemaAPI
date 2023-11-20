package com.cinema.dto;

import java.sql.Date;

public class FilmDTO {
	
	private long id;
	private String title;
	private String length;
	private Date releaseDate;
	private String actor;
	private String director;
	private String describe;
	private String posters;
	
	public FilmDTO() {
		
	}
	public FilmDTO(long id, String title, String length, Date releaseDate, String actor, String director,
			String describe,String posters) {
		super();
		this.id = id;
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.actor = actor;
		this.director = director;
		this.describe = describe;
		this.posters = posters;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPosters() {
		return posters;
	}
	public void setPosters(String posters) {
		this.posters = posters;
	}
	
	
}
