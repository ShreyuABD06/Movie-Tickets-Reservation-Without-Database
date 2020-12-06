package com.movie.bo;

import java.util.List;

import com.movie.dao.TheatreDAOImpl;
import com.movie.domain.Theatre;

public class TheatreBO {
TheatreDAOImpl dao=new TheatreDAOImpl();
	public String addTheatre(Theatre theatre) {
		return dao.AddTheatre(theatre);
	}
	public List<Theatre> getTheatres() {
		return dao.getTheatres();
	}
	public Theatre getTheatreByName(String theatreName) {
		// TODO Auto-generated method stub
		return dao.getTheatreByName(theatreName);
	}

}
