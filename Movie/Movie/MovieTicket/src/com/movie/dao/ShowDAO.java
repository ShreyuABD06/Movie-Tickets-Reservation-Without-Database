package com.movie.dao;
import java.util.ArrayList;
import java.util.List;

import com.movie.domain.Show;

public interface ShowDAO {
	public ArrayList<Show> getShows();
	public String AddShow(Show show);
	public String updateShow(Show show);
	public String deleteShow(Show show);
	public List<Show> getShowByTheatre(String theatreName) ;
	public List<Show> getShowByMovie(String movieName) ;
	public Show getShowByMovieAndTheatre(String movieName, String theatreName) ;
}
