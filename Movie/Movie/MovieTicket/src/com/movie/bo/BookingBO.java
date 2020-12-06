package com.movie.bo;

import java.util.ArrayList;
import java.util.List;

import com.movie.dao.BookingDAOImpl;
import com.movie.domain.Booking;

public class BookingBO {
BookingDAOImpl dao=new BookingDAOImpl();
	public List<Booking> getBookings() {
		return dao.getBookings();
	}
	public ArrayList<Booking> getBookingsByMovieAndTheatre(String movieName, String theatreName) {
		return dao.getBookingsByMovieAndTheatre(movieName,theatreName);
	}
	public Boolean bookTicket(Booking cb) {
		return dao.BookTicket(cb);
	}
	public String updateBooking(Booking cb) {
		return dao.UpdateBooking(cb);
	}
	public Booking getBookingByEmailTheatreMovie(String email, String movieName, String theatreName) {
		// TODO Auto-generated method stub
		return dao.getBookingByEmailTheatreMovie(email,movieName,theatreName);
	}
	public Boolean CancelBooking(Booking bo) {
		// TODO Auto-generated method stub
		return dao.CancelBooking(bo);
	}

}
