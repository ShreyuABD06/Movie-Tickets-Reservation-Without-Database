package com.movie.domain;

public class Cast {
	public String hero;
	public String heroine;
	public String director;
	
	public Cast(String hero, String heroine, String director) {
		super();
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
	}
	public Cast() {
		// TODO Auto-generated constructor stub
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getHeroine() {
		return heroine;
	}
	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
}
