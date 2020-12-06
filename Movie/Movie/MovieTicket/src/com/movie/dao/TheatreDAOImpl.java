package com.movie.dao;
import java.util.ArrayList;

import com.movie.domain.Movie;
import com.movie.domain.Theatre;

public class TheatreDAOImpl implements TheatreDAO{
	ArrayList<Theatre> theatreList=new ArrayList<Theatre>() {{
	add(new Theatre(1,"Anjani","Bangalore","9123667671",100));
	add(new Theatre(2,"Manasa","Tumkur","9123667672",100));
	add(new Theatre(3,"Balaji","Chikkaballapur","9123647671",100));
	}
	}	;

	@Override
	public ArrayList<Theatre> getTheatres() {
//		theatreList=new ArrayList<>();
//		theatreList.add(new Theatre(1,"Anjani","Bangalore",100));
//		theatreList.add(new Theatre(2,"Manasa","Tumkur",100));
//		theatreList.add(new Theatre(1,"Balaji","Chikkaballapur",100));
		return theatreList;
	}

	@Override
	public String AddTheatre(Theatre theatre) {
		for(Theatre m:theatreList) {
			if(m.getTheatreName().equals(theatre.getTheatreName())) {
				return null;
			}
		}
		theatreList.add(theatre);
		return "Theatre Added";
	}

	@Override
	public String UpdateTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DeleteTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		return null;
	}

	public Theatre getTheatreByName(String theatreName) {
		for(Theatre t:theatreList) {
			if(t.getTheatreName().equals(theatreName)) {
				return t;
			}
		}
		return null;
	}

}
