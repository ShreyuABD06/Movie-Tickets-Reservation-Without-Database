package com.movie.bo;

import java.util.List;

import com.movie.dao.ShowDAOImpl;
import com.movie.domain.Show;

public class ShowBO {
ShowDAOImpl dao=new ShowDAOImpl();
	public String addShow(Show show) {
		return dao.AddShow(show);
	}
	public List<Show> getShows() {
		return dao.getShows();
	}
	public Show getShowByMovieAndTheatre(String movieName, String theatreName) {
		return dao.getShowByMovieAndTheatre(movieName,theatreName);
	}
	public String updateShow(Show s) {
		return dao.updateShow(s);
	}
	public String deleteShow(Show s) {
		return dao.deleteShow(s);
	}
	public List<Show> getShowByTheatre(String theatreName) {
		return dao.getShowByTheatre(theatreName);
	}
	public List<Show> getShowByMovie(String movieName) {
		return dao.getShowByMovie(movieName);
	}

}
