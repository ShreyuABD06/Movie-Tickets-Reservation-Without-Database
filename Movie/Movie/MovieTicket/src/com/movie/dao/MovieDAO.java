package com.movie.dao;
import java.util.ArrayList;
import com.movie.domain.Movie;

public interface MovieDAO {
public ArrayList<Movie> getMovies();
public String AddMovie(Movie movie);
public String UpdateMovie(Movie movie);
public String DeleteMovie(Movie movie);
}
