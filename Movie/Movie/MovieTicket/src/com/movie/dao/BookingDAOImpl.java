package com.movie.dao;

import java.util.ArrayList;

import com.movie.domain.Booking;
import com.movie.domain.Show;
import com.movie.domain.Theatre;

public class BookingDAOImpl implements BookingDAO{
	ArrayList<Booking> bookings=new ArrayList<>();
	@Override
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	@Override
	public Boolean BookTicket(Booking booking) {
		for(Booking m:bookings) {
			if(m.getCustomer().getEmail().equals(booking.getCustomer().getEmail()) &&
					m.getShow().getMovie().getMovieName().equals(booking.getShow().getMovie().getMovieName()) && 
					m.getShow().getMovie().getTheatre().getTheatreName().equals(booking.getShow().getMovie().getTheatre().getTheatreName())) {
				return false;
			}
		}
		bookings.add(booking);
		return true;
	}

	@Override
	public String UpdateBooking(Booking booking) {
		for(int i=0;i<bookings.size();i++) {
			String theatre=booking.getShow().getMovie().getTheatre().getTheatreName();
			String movie=booking.getShow().getMovie().getMovieName();
			int noOfTickets=bookings.get(i).getNoOfTickets()+booking.getNoOfTickets();
			if(bookings.get(i).getShow().getMovie().getMovieName().equals(movie) && bookings.get(i).getShow().getMovie().getTheatre().getTheatreName().equals(theatre)) {
				booking.setNoOfTickets(noOfTickets);
				bookings.set(i, booking);
			}
		}
 		return "Tickets Added";
	}

	@Override
	public Boolean CancelBooking(Booking booking) {
		for(int i=0;i<bookings.size();i++) {
			String theatre=booking.getShow().getMovie().getTheatre().getTheatreName();
			String movie=booking.getShow().getMovie().getMovieName();
			String email=booking.getCustomer().getEmail();
			if(bookings.get(i).getShow().getMovie().getMovieName().equals(movie) && 
					bookings.get(i).getShow().getMovie().getTheatre().getTheatreName().equals(theatre)
					&& bookings.get(i).getCustomer().getEmail().equals(email)) {
				bookings.remove(bookings.get(i));
				return true;
			}
		}
		return false;
	}

	public ArrayList<Booking> getBookingsByMovieAndTheatre(String movieName, String theatreName) {
		ArrayList<Booking> b=new ArrayList<>();
		for(Booking c:bookings) {
			if(c.getShow().getMovie().getMovieName().equals(movieName) && c.getShow().getMovie().getTheatre().getTheatreName().equals(theatreName)) {
				b.add(c);
			}
		}
		return b;
	}

	public Booking getBookingByEmailTheatreMovie(String email, String movieName, String theatreName) {
		for(Booking m:bookings) {
			if(m.getCustomer().getEmail().equals(email) &&
					m.getShow().getMovie().getMovieName().equals(movieName) && 
					m.getShow().getMovie().getTheatre().getTheatreName().equals(theatreName)) {
				return m;
			}
		}
		return null;
	}

}
