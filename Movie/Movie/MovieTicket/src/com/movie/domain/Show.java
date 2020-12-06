package com.movie.domain;

public class Show {
	public int id;
	public Movie movie;
	public double cost;
	
	public Show(int id, Movie movie, double cost) {
		super();
		this.id = id;
		this.movie = movie;
		this.cost = cost;
	}
	public Show() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
