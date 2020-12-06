package com.movie.dao;

import java.util.ArrayList;

import com.movie.domain.Cast;
import com.movie.domain.Movie;
import com.movie.domain.Theatre;

public class MovieDAOImpl implements MovieDAO{
	TheatreDAOImpl ti=new TheatreDAOImpl();
	ArrayList<Theatre> theatreList=ti.getTheatres();
	ArrayList<Movie> movieList=new ArrayList<Movie>() {{
		add(new Movie(1,"Avengers",theatreList.get(0),null,new Cast("Tony","Scarlet","Russo Bros")));
		add(new Movie(2,"Thugs",theatreList.get(2),null,new Cast("Amir Khan","Fathima","Bansali")));
		add(new Movie(3,"Sarkar",theatreList.get(1),null,new Cast("Vijay","Keerthi","AR Murugadas")));		
		}
		}	;
	@Override
	public ArrayList<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public String AddMovie(Movie movie) {
		for(Movie m:movieList) {
			if(m.getMovieName().equals(movie.getMovieName()) && m.getTheatre().getTheatreName().equals(movie.getTheatre().getTheatreName())) {
				return null;
			}
		}
		movieList.add(movie);
		return "Movie Added";
	}

	@Override
	public String UpdateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DeleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	public Movie getMovieByMovieAndTheatre(String movieName, String theatreName) {
		for(Movie m:movieList) {
			if(m.getMovieName().equals(movieName) && m.getTheatre().getTheatreName().equals(theatreName)) {
				return m;
			}
		}
		return null;
	}

}
