package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import com.movie.domain.Cast;
import com.movie.domain.Movie;
import com.movie.domain.Show;
public class ShowDAOImpl implements ShowDAO {
	MovieDAOImpl ti=new MovieDAOImpl();
	ArrayList<Movie> movieList=ti.getMovies();
	ArrayList<Show> showList=new ArrayList<Show>() {{
		add(new Show(1,movieList.get(1),100.00));
		add(new Show(2,movieList.get(2),100.00));
		add(new Show(0,movieList.get(0),100.00));
		}
		}	;
	@Override
	public ArrayList<Show> getShows() {
		return showList;
	}

	@Override
	public String AddShow(Show show) {
		for(Show m:showList) {
			if(m.getMovie().getMovieName().equals(show.getMovie().getMovieName()) && m.getMovie().getTheatre().getTheatreName().equals(show.getMovie().getTheatre().getTheatreName())) {
				return null;
			}
		}
		showList.add(show);
		return "Show Added";
	}

	@Override
	public String updateShow(Show show) {
		for(int i=0;i<showList.size();i++) {
			String theatre=show.getMovie().getTheatre().getTheatreName();
			String movie=show.getMovie().getMovieName();
			if(showList.get(i).getMovie().getMovieName().equals(movie) && showList.get(i).getMovie().getTheatre().getTheatreName().equals(theatre)) {
				showList.set(i, show);
			}
		}
//		for(Show s:showList) {
//			if(s.getMovie().getMovieName().equals(show.getMovie().getMovieName()) && 
//					s.getMovie().getTheatre().getTheatreName().equals(show.getMovie().getTheatre().getTheatreName())) {
//				s.setCost(show.getCost());
//			}
//		}
		return "Show Updated";
	}

	@Override
	public String deleteShow(Show show) {
		for(int i=0;i<showList.size();i++) {
			String theatre=show.getMovie().getTheatre().getTheatreName();
			String movie=show.getMovie().getMovieName();
			if(showList.get(i).getMovie().getMovieName().equals(movie) && showList.get(i).getMovie().getTheatre().getTheatreName().equals(theatre)) {
				showList.remove(showList.get(i));
			}
		}
//		for(Show s:showList) {
//			if(s.getMovie().getMovieName().equals(show.getMovie().getMovieName()) && 
//					s.getMovie().getTheatre().getTheatreName().equals(show.getMovie().getTheatre().getTheatreName())) {
//				showList.remove(s);
//			}
//		}
		//Commented lines works fine but most of the time gives concurrentModification exception due to fail fast condition
		return "Show Deleted";
	}

	public Show getShowByMovieAndTheatre(String movieName, String theatreName) {
		for(Show s:showList) {
			if(s.getMovie().getMovieName().equals(movieName) && s.getMovie().getTheatre().getTheatreName().equals(theatreName)) {
				return s;
			}
		}
		return null;
	}

	public List<Show> getShowByTheatre(String theatreName) {
		ArrayList<Show> dup=new ArrayList<>();
		for(Show s:showList) {
			if(s.getMovie().getTheatre().getTheatreName().equals(theatreName)) {
				dup.add(s);
			}
		}
		return dup;
	}

	public List<Show> getShowByMovie(String movieName) {
		ArrayList<Show> dup=new ArrayList<>();
		for(Show s:showList) {
			if(s.getMovie().getMovieName().equals(movieName)) {
				dup.add(s);
			}
		}
		return dup;
	}
}
