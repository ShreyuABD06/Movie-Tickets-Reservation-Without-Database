package com.movie.domain;

import java.util.Date;

public class Movie {
	public int id;
	public String movieName;
	public Theatre theatre;
	public Date releaseDate;
	public Cast cast;
	public Movie(){
		
	}
	public Movie(int id, String movieName, Theatre theatre, Date releaseDate, Cast cast) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.theatre = theatre;
		this.releaseDate = releaseDate;
		this.cast = cast;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Cast getCast() {
		return cast;
	}
	public void setCast(Cast cast) {
		this.cast = cast;
	}
	
	
}
