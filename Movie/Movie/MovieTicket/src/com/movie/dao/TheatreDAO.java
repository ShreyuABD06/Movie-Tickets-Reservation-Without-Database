package com.movie.dao;
import java.util.ArrayList;

import com.movie.domain.Theatre;

public interface TheatreDAO {
	public ArrayList<Theatre> getTheatres();
	public String AddTheatre(Theatre theatre);
	public String UpdateTheatre(Theatre theatre);
	public String DeleteTheatre(Theatre theatre);
	public Theatre getTheatreByName(String theatreName);
}
