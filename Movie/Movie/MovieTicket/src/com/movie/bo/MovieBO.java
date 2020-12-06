package com.movie.bo;

import java.util.List;

import com.movie.dao.MovieDAOImpl;
import com.movie.domain.Movie;

public class MovieBO {
MovieDAOImpl dbo=new MovieDAOImpl();
	public String addMovie(Movie movie) {
		return dbo.AddMovie(movie);
	}

	public List<Movie> getMovies() {
		return dbo.getMovies();
	}

	public Movie getMovieByMovieAndTheatre(String movieName, String theatreName) {
		return dbo.getMovieByMovieAndTheatre(movieName,theatreName);
	}

}
