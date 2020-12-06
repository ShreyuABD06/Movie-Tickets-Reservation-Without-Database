package com.movie.dao;
import java.util.ArrayList;
import com.movie.domain.Booking;

public interface BookingDAO {
	public ArrayList<Booking> getBookings();
	public Boolean BookTicket(Booking booking);
	public String UpdateBooking(Booking booking);
	public Boolean CancelBooking(Booking booking);
	public ArrayList<Booking> getBookingsByMovieAndTheatre(String movieName, String theatreName) ;
	public Booking getBookingByEmailTheatreMovie(String email, String movieName, String theatreName);
}
