package com.movie.main;

import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.movie.bo.AdminValidateBO;
import com.movie.bo.BookingBO;
import com.movie.bo.CustomerBO;
import com.movie.bo.MovieBO;
import com.movie.bo.ShowBO;
import com.movie.bo.TheatreBO;
import com.movie.domain.Booking;
import com.movie.domain.Cast;
import com.movie.domain.Customer;
import com.movie.domain.Movie;
import com.movie.domain.Show;
import com.movie.domain.Theatre;

public class Main {
	Scanner sc=null;
	public static void main(String[] args) {
		Main main=new Main();
		main.choose();
		
	}
	private void choose() {

		this.sc = new Scanner(System.in);
		do {
			System.out.println(
					"\n---------------------------**************************WELCOME TO MOVIE TICKET RESERVATION***********************-------------------------------------\n\n");
			System.out.println("HOME: 1:ADMIN  2:CUSTOMER  3:exit");
			System.out.println(
					"\n-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Enter your Choice");
			int choice = this.getUserChoice2();
			switch (choice) {
			case 1:
				System.out.println("Enter your Username :");
				AdminValidateBO admin = new AdminValidateBO();
				String username = sc.next();
				System.out.println("Enter your Password :");
				String password = sc.next();
				boolean check = admin.adminValidate(username, password);
				if (check) {
				this.manage();
				}else{
					System.out.println("Enter Valid username and password");
				}
				break;
			case 2:
				this.customer();
				break;
			case 3: {
				System.out.println("Closing All Tabs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Thank You ............Visit Again");
				System.exit(0);
			}default:
				System.out.println("Enter Valid Choice");
			}
		} while (true);
	}
	private void manage() {
		MovieBO mbo = new MovieBO();
		TheatreBO tbo=new TheatreBO();
		ShowBO sbo=new ShowBO();
		CustomerBO cbo=new CustomerBO();
		BookingBO bbo=new BookingBO();
		
		this.sc = new Scanner(System.in);
		do {
			System.out.println(
					"\n---------------------------**************************WELCOME TO MOVIE TICKET RESERVATION***********************-------------------------------------\n\n");
			System.out.println("\n1:Add Theatre    2:View Theatres \n3:Add Movie     4:View Movies\n  5: Add Shows      6:View Shows\n");
			System.out.println("\n7:Update Show     8:Delete Show      \n9:View Bookings      10: Get Customers By Show(Theatre And Movie)\n");
			System.out.println("11:Exit\n");
			System.out.println(
					"\n-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Enter your Choice");
			int choice = this.getUserChoice();
			switch (choice) {
			case 1: {
				Theatre theatre = new Theatre();
				System.out.println("Enter Theatre Name");
				String theatreName = sc.next();
				theatre.setTheatreName(theatreName);
				System.out.println("Enter Theatre Location");
				String location = sc.next();
				theatre.setLocation(location);
				System.out.println("Enter phone No");
				String phoneNo = sc.next();
				while (!this.checkContainDigits(phoneNo)) {
					System.out.println("Enter the valid mobile number :");
					phoneNo = this.sc.nextLine();
				}
				theatre.setPhoneNo(phoneNo);
				System.out.println("Enter Seating Capacity");
				int seatingCapacity = sc.nextInt();
				theatre.setSeatingCapacity(seatingCapacity);
				String s = tbo.addTheatre(theatre);
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (s != null) {
					System.out.println(
							"------------------------------------****Theatre Added****-----------------------------------");
				} else {
					System.out.println("Theatre could nOt Be Added or Theatre Already Exist");
				}
				break;
			}
			case 2: {
				List<Theatre> list = tbo.getTheatres();
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (list != null) {
					System.out.println(
							"------------------------------------****Theatres Around You****-----------------------------------");
					System.out.format("%-25s | %-30s | %-30s | %-10s\n","Theatre Name","Phone No","Location","Seating Capacity");
					System.out.println("--------------------------------------------------------------------------------------------------------------");
					for(Theatre t:list) {
						System.out.format("%-25s | %-30s | %-30s | %-10s\n",t.getTheatreName(),t.getPhoneNo(),t.getLocation(),t.getSeatingCapacity());
					}
//					Iterator<Theatre> itr = list.iterator();
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
				} else {
					System.out.println("No Theatres Found");
				}
				break;
			}
			case 3: {
				Movie movie = new Movie();
				Cast cast=new Cast();
				System.out.println("Enter Movie Name");
				String movieName = sc.next();
				movie.setMovieName(movieName);
				System.out.println("Enter Director Name");
				String director=sc.next();
				cast.setDirector(director);
				System.out.println("Enter Hero Name");
				String hero = sc.next();
				cast.setHero(hero);
				System.out.println("Enter Heroine Name");
				String heroine = sc.next();
				cast.setHeroine(heroine);
				movie.setCast(cast);
				System.out.println("Enter Release Date(yyyy-MM-dd)");
				String date=sc.next();
				while (!this.checkValidDate(date)) {
					System.out.println("Enter the valid Date:");
					date = this.sc.nextLine();
				}
				try {
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					Date releaseDate= sdf.parse(date);
					movie.setReleaseDate(releaseDate);	
				}catch(ParseException p) {
					p.printStackTrace();
				}
					 
				System.out.println("Enter Theatre to which movie has to be added");
				String theatreName=sc.next();
				Theatre theatre=tbo.getTheatreByName(theatreName);
				while (theatre==null) {
					System.out.println("Enter Available TheatreName Only....!:");
					theatreName = this.sc.nextLine();
					theatre=tbo.getTheatreByName(theatreName);
				}
				movie.setTheatre(theatre);				
				String cr = mbo.addMovie(movie);
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (cr != null) {
					System.out.println(
							"------------------------------------****Movie Added****-----------------------------------");
				} else {
					System.out.println("Movie Could Not Be Added or Movie Already Exists in that Theatre");
				}
				break;
			}
			case 4: {
				List<Movie> m = mbo.getMovies();
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (m != null) {
					System.out.println(
							"------------------------------------****Movies****-----------------------------------");
					System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s\n","Movie Name","Hero ","Heroine","Director","Release Date");
					System.out.println("--------------------------------------------------------------------------------------------------------------");
					for(Movie l:m) {
						System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s\n",l.getMovieName(),l.getCast().getHero(),l.getCast().getHeroine()
								,l.getCast().getDirector(),l.getReleaseDate());
					}
//					Iterator<Movie> itr = m.iterator();
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
				} else {
					System.out.println("No Movies to Display");
				}
				break;
			}
			case 5: {
				Show show = new Show();
				System.out.println("Enter Movie Name");
				String movieName = sc.next();
				System.out.println("Enter Theatre Name");
				String theatreName=sc.next();
				Movie m=mbo.getMovieByMovieAndTheatre(movieName,theatreName);
				while (m==null) {
					System.out.println("Enter Available Theatre and Movie Only....!:");
					System.out.println("Enter Movie Name");
					movieName = this.sc.next();
					System.out.println("Enter Theatre Name");
					theatreName = this.sc.next();
					 m=mbo.getMovieByMovieAndTheatre(movieName,theatreName);
					// System.out.println(m.getMovieName());
				}
				show.setMovie(m);
				System.out.println("Enter Cost for Show");
				Double cost=sc.nextDouble();
				show.setCost(cost);
				String sh = sbo.addShow(show);
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (sh != null) {
					System.out.println(
							"------------------------------------******Show Added******-----------------------------------");
				} else {
					System.out.println("Could nOt Add Show or Show Already Exists in that Theatre....Try Again:)");
				}
				break;
			}
			case 6: {
				List<Show> list1 = sbo.getShows();
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (list1 != null) {
					System.out.println(
							"------------------------------------*******Shows*******-----------------------------------");
					System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s  |%-20s\n","Movie Name","Hero ",
							"Release Date","Theatre","Location","Cost","Seating Capacity");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for(Show s:list1) {
						System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",s.getMovie().getMovieName(),
								s.getMovie().getCast().getHero(),s.getMovie().getReleaseDate(),s.getMovie().getTheatre().getTheatreName(),
								s.getMovie().getTheatre().getLocation(),s.getCost(),s.getMovie().getTheatre().getSeatingCapacity());
					}
//					Iterator<Show> itr = list1.iterator();
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
				} else {
					System.out.println("No Shows to Display");
				}
				break;
			}
			case 7: {
				System.out.println("Enter movie Name and theatre to Be Updated");
				System.out.println("Enter Movie Name");
				String movieName = sc.next();
				System.out.println("Enter Theatre Name");
				String theatreName=sc.next();
				
				Show s=sbo.getShowByMovieAndTheatre(movieName,theatreName);
				while (s==null) {
					System.out.println("Enter Available Theatre and Movie Only....!:");
					System.out.println("Enter Movie Name");
					movieName = this.sc.next();
					System.out.println("Enter Theatre Name");
					theatreName = this.sc.next();
					 s=sbo.getShowByMovieAndTheatre(movieName,theatreName);
					// System.out.println(m.getMovieName());
				}
				//Movie movie=mbo.getMovieByMovieAndTheatre(movieName, theatreName);
				//Print show here
				System.out.println("Enter New Cost");
				Double cost=sc.nextDouble();
				s.setCost(cost);
				//s.setMovie(movie);
				String up=sbo.updateShow(s);
				System.out.println(up);
				break;
			}
			case 8: {
				System.out.println("Enter movie Name and theatre to Be Deleted");
				System.out.println("Enter Movie Name");
				String movieName = sc.next();
				System.out.println("Enter Theatre Name");
				String theatreName=sc.next();
				//Movie movie=mbo.getMovieByMovieAndTheatre(movieName, theatreName);
				Show s=sbo.getShowByMovieAndTheatre(movieName,theatreName);
				//Print show here
				//Print show here
				//Double cost=sc.nextDouble();
				//s.setCost(cost);
				//s.setMovie(movie);
				String del=sbo.deleteShow(s);
				System.out.println(del);
				break;
			}
			case 9: {
				List<Booking> c1 = bbo.getBookings();
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (c1 != null) {
					System.out.println(
							"------------------------------------*******Booking DEtails*******-----------------------------------");
					System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n","Customer Name","Movie Name",
							"Theatre","Location","No of Tickets","Total Cost");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for(Booking b:c1) {
						System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",b.getCustomer().getName(),b.getShow().getMovie().getMovieName(),
								b.getShow().getMovie().getTheatre().getTheatreName(),b.getShow().getMovie().getTheatre().getLocation(),b.getNoOfTickets(),
								(b.getShow().getCost()*b.getNoOfTickets()));
					}
//					Iterator<Booking> itr = c1.iterator();
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
				} else {
					System.out.println("No Bookings");
				}
				break;
			}
			case 10: System.out.println("Enter movie Name and theatre to To find bookings for the show");
			System.out.println("Enter Movie Name");
			String movieName = sc.next();
			System.out.println("Enter Theatre Name");
			String theatreName=sc.next();
			ArrayList<Booking>booked=bbo.getBookingsByMovieAndTheatre(movieName, theatreName);
			if (booked != null) {
				System.out.println(
						"------------------------------------*******Booking DEtails*******-----------------------------------");
				System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n","Customer Name","Movie Name",
						"Theatre","Location","No of Tickets","Total Cost");
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				for(Booking b:booked) {
					System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",b.getCustomer().getName(),b.getShow().getMovie().getMovieName(),
							b.getShow().getMovie().getTheatre().getTheatreName(),b.getShow().getMovie().getTheatre().getLocation(),b.getNoOfTickets(),
							(b.getShow().getCost()*b.getNoOfTickets()));
				}
//				Iterator<Booking> itr = c1.iterator();
//				while (itr.hasNext()) {
//					System.out.println(itr.next());
//				}
			} else {
				System.out.println("No Bookings");
			}
			//Show s=sbo.getShowByMovieAndTheatre(movieName,theatreName);
			case 11: {
				System.out.println("Closing All Tabs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Thank You Admin yo Hava Logged Out............");
				
				return;
			}
			}
		} while (true);
	}

	private void customer() {
		// cancelBooking1();
		ShowBO sbo=new ShowBO();
		this.sc = new Scanner(System.in);
		do {
			System.out.println(
					"\n---------------------------**************************WELCOME TO MOVIE TICKET RESERVATION***********************-------------------------------------\n\n");
			System.out.println(
					"Book: 1:View Shows   2:Find Show(By Theatre)    3:Find Show(By Movie)    4:book movie 5:CancelBooking 6:exit");
			System.out.println(
					"\n-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Enter your Choice");
			int choice = this.getUserChoice1();
			switch (choice) {
			case 1: {
				List<Show> list1 = sbo.getShows();
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (list1 != null) {
					System.out.println(
							"------------------------------------*******Shows*******-----------------------------------");
					System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s  |%-20s\n","Movie Name","Hero ",
							"Release Date","Theatre","Location","Cost","Seating Capacity");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for(Show s:list1) {
						System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",s.getMovie().getMovieName(),
								s.getMovie().getCast().getHero(),s.getMovie().getReleaseDate(),s.getMovie().getTheatre().getTheatreName(),
								s.getMovie().getTheatre().getLocation(),s.getCost(),s.getMovie().getTheatre().getSeatingCapacity());
					}
//					Iterator<Show> itr = list1.iterator();
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
				} else {
					System.out.println("No Shows to Display");
				}
				break;
			}
			case 2: {
				System.out.println("Enter Theatre Name");
				String theatreName=sc.next();
				List<Show> list1 = sbo.getShowByTheatre(theatreName);
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (list1 != null) {
					System.out.println(
							"------------------------------------*******Shows*******-----------------------------------");
					System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s  |%-20s\n","Movie Name","Hero ",
							"Release Date","Theatre","Location","Cost","Seating Capacity");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for(Show s:list1) {
						System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",s.getMovie().getMovieName(),
								s.getMovie().getCast().getHero(),s.getMovie().getReleaseDate(),s.getMovie().getTheatre().getTheatreName(),
								s.getMovie().getTheatre().getLocation(),s.getCost(),s.getMovie().getTheatre().getSeatingCapacity());
					}
//					Iterator<Show> itr = list1.iterator();
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
				} else {
					System.out.println("No Shows to Display");
				}
				break;
			}
			case 3: {
				System.out.println("Enter Movie Name");
				String movieName = sc.next();
				List<Show> list1 = sbo.getShowByMovie(movieName);
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (list1 != null) {
					System.out.println(
							"------------------------------------*******Shows*******-----------------------------------");
					System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s  |%-20s\n","Movie Name","Hero ",
							"Release Date","Theatre","Location","Cost","Seating Capacity");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for(Show s:list1) {
						System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",s.getMovie().getMovieName(),
								s.getMovie().getCast().getHero(),s.getMovie().getReleaseDate(),s.getMovie().getTheatre().getTheatreName(),
								s.getMovie().getTheatre().getLocation(),s.getCost(),s.getMovie().getTheatre().getSeatingCapacity());
					}
//					Iterator<Show> itr = list1.iterator();
//					while (itr.hasNext()) {
//						System.out.println(itr.next());
//					}
				} else {
					System.out.println("No Shows to Display");
				}
				break;
			}
			
			case 4: {
				bookMovie();
				break;
			}
			case 5: {
				cancelBooking();
				break;
			}
			case 6: {
				System.out.println("Closing All Tabs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Thank You Visit Again............");
				return;
			}
			}
		} while (true);
	}
	private void bookMovie() {
		MovieBO mbo = new MovieBO();
		TheatreBO tbo=new TheatreBO();
		ShowBO sbo=new ShowBO();
		CustomerBO cbo=new CustomerBO();
		BookingBO bbo=new BookingBO();
		this.sc = new Scanner(System.in);
		do {
			System.out.println(
					"-----------------------------------------------------------------------Welcome To Booking Module-----------------------------------------------------");
			System.out.println("Book: 1:Register Customer 2:Book Movie 3:exit");
			System.out.println(
					"\n-------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Enter your Choice");
			int choice = this.getUserChoice2();
			switch (choice) {
			case 1: {
				Customer customer = new Customer();
				System.out.println("Enter Your Name");
				String name = sc.next();
				customer.setName(name);
				System.out.println("Enter your Mobile No");
				String phoneNo = sc.next();
				while (!this.checkContainDigits(phoneNo)) {
					System.out.println("Enter a valid mobile number :");
					phoneNo = this.sc.nextLine();
				}
				customer.setMobile(phoneNo);
				boolean isValid = false;
				System.out.println("Enter the email : Ex (abc@gmail.com) :");
				String email = this.sc.nextLine();
				while (!isValid) {
					isValid = this.isValidEmail(email);
					if (isValid)
						break;
					System.out.println("invalid mail");
					System.out.println("Enter the email : Ex (abc@gmail.com) :");
					email = this.sc.nextLine();
				}
				customer.setEmail(email);	
				
				String cust = cbo.registerCustomer(customer);
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (cust != null) {
				//	System.out.println("Customer : " + cust);
					System.out.println("Thank You You have been Registered Successfully ");
				} else {
					System.out.println("Could nOt register or duplicate Credentials ....Try Again:)");
				}
				break;
			}
			case 2: {
				Customer cus = new Customer();
				System.out.println("Enter Your Registered email");
				String email = sc.next();
				cus = cbo.getCustomerByEmail(email);
				if (cus != null) {
					System.out.println("Welcome,You can book ur Tickets Now..........:)");
					List<Show> list1 = sbo.getShows();
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if (list1 != null) {
						System.out.println(
								"------------------------------------*******Available Shows*******-----------------------------------");
						System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s  |%-20s\n","Movie Name","Hero ",
								"Release Date","Theatre","Location","Cost","Seating Capacity");
						System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						for(Show s:list1) {
							System.out.format("%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s\n",s.getMovie().getMovieName(),
									s.getMovie().getCast().getHero(),s.getMovie().getReleaseDate(),s.getMovie().getTheatre().getTheatreName(),
									s.getMovie().getTheatre().getLocation(),s.getCost(),s.getMovie().getTheatre().getSeatingCapacity());
						}
					} else {
						System.out.println("No Shows to Display");
					}
					Booking cb = new Booking();
					// System.out.println("Enter Customer Id to Book a
					// Show");z// int customerId = sc.nextInt();
					//cb.setCustomerId(id);
					System.out.println("Enter Movie and theatre to which u wish to book ticket for");
					System.out.println("Enter Movie Name");
					String movieName = sc.next();
					System.out.println("Enter Theatre Name");
					String theatreName=sc.next();
					
					Show s=sbo.getShowByMovieAndTheatre(movieName,theatreName);
					while (s==null) {
						System.out.println("Your Request is Currently Unavailable Please Try Other Options:");
						System.out.println("Enter Movie Name");
						movieName = this.sc.next();
						System.out.println("Enter Theatre Name");
						theatreName = this.sc.next();
						 s=sbo.getShowByMovieAndTheatre(movieName,theatreName);
						// System.out.println(m.getMovieName());
					}
					if (s != null) {
						System.out.println("Enter no of tickets");
						int noOfTickets = sc.nextInt();
						cb.setNoOfTickets(noOfTickets);
						cb.setCustomer(cus);
						cb.setShow(s);
						cb.setNoOfTickets(noOfTickets);
						int i = paybill(cus, s, noOfTickets);
						// cb.setNoOfTickets(noOfTickets);
						if (i == 1) {
							Boolean isBooked=bbo.bookTicket(cb);
							System.out.println("Please wait .......................... ");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							if (isBooked) {
								System.out.println("your tickets are Booked");
//								Show sh = new Show();
//								sh = c.updateSeatsAvailable(sh, showId, noOfTickets);
//								System.out.println(sh);								
								// paybill(showId,id,noOfTickets);
							}else {
								String u=bbo.updateBooking(cb);
								System.out.println("your tickets are Booked");
							}
						}
					}
//					else {
//						System.out.println("Requested Show Unavailable.......");
//					}
				} else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("Please Register yourself Before you Book");
				}
				break;
			}

			case 3: {
				System.out.println("Closing All Tabs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Thank You Visit Again............");
				return;
			}
			}
		} while (true);

	}
	
	private void cancelBooking() {
		MovieBO mbo = new MovieBO();
		TheatreBO tbo=new TheatreBO();
		ShowBO sbo=new ShowBO();
		CustomerBO cbo=new CustomerBO();
		BookingBO bbo=new BookingBO();
		Customer cus = new Customer();
		System.out.println("enter your email");
		String email = sc.next();
		cus = cbo.getCustomerByEmail(email);
		if (cus != null) {
			Booking bo=new Booking();
			System.out.println("Welcome !!!!!!!!!!!!!....");
			System.out.println("Enter Movie And Theatre to which booking to Be Cancelled");
			System.out.println("Enter Movie Name");
			String movieName = sc.next();
			System.out.println("Enter Theatre Name");
			String theatreName=sc.next();
			bo=bbo.getBookingByEmailTheatreMovie(email,movieName,theatreName);
			while(bo==null) {
				System.out.println("Enter Movie And Theatre to which booking to Be Cancelled");
				System.out.println("Enter Movie Name");
				movieName = sc.next();
				System.out.println("Enter Theatre Name");
				theatreName=sc.next();
				bo=bbo.getBookingByEmailTheatreMovie(email,movieName,theatreName);
				System.out.println("Are you sure you want to cancel Booking(y/n)");
				String d = sc.next();
				if (d.equalsIgnoreCase("y")) {
					
				}else {
					return;
				}
			}
			System.out.println("Are you sure you want to cancel Booking(y/n)");
			String d = sc.next();
			if (d.equalsIgnoreCase("y")) {
				Boolean cancelled = bbo.CancelBooking(bo);
				System.out.println("Please wait .......................... ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (cancelled ) {
					System.out.println("Your booking for show was Cancelled..............");
					System.out.println("Go to Booking portal to continue Booking.........");
				}
			}
		} else {
			System.out.println("Sorry......you have not Registered at all............:)");
		}

	}
	
	private int paybill(Customer cus, Show s, int noOfTickets) {
		this.sc = new Scanner(System.in);
		do {
			System.out.println("Please Pay your Bill");
			System.out.println("How Do Yo Wish To Pay(  1:Cash  2:Card 3:exit  ");
			System.out.println("Enter your Choice");
			int choice = this.getUserChoice2();
			switch (choice) {
			case 1: {
				System.out.println("Confirm your tickets By Paying......(y/n)");
				String d = sc.next();
				if (d.equalsIgnoreCase("y")) {
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("Generating Bill ........");
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Double n = s.getCost();
					Double totalCost = n * noOfTickets;
					System.out.println("no of Tickets Purchased=" + noOfTickets);
					System.out.println(noOfTickets + " * " + n + " = " + totalCost);
					System.out.println("Please Pay Rupees " + totalCost);
					System.out.println("customer paid(y/n)");
					String d1 = sc.next();
					if (d1.equalsIgnoreCase("y")) {
						return 1;
					} else {
						System.out.println("Transaction Cancelled........Amount was not Collected");
						System.out.println("Thank You");
						return 0;
					}
				} else {
					System.out.println("You Must Pay Before Booking");
				}
				break;
			}
			case 2: {
				System.out.println("Please Enter your Card Number(XXXX)");
				String cardNo = sc.next();
				while (!this.checkContainDigits(cardNo)) {
					System.out.println("Enter the valid card number :");
					cardNo = this.sc.nextLine();
				}
				System.out.println("Please Wait While we confirm With the Bank");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Please wait,It willl take a while .......................... ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Card Number Verified");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Confirm your tickets By Paying......(y/n)");
				String d = sc.next();
				if (d.equalsIgnoreCase("y")) {
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("Generating Bill ........");
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Double n = s.getCost();
					Double totalCost = n * noOfTickets;
					System.out.println("no of Tickets Purchased=" + noOfTickets);
					System.out.println("Please Pay Rupees " + totalCost);
					System.out.println("customer paid(y/n)");
					String d1 = sc.next();
					if (d1.equalsIgnoreCase("y")) {
						return 1;
					} else {
						System.out.println("Transaction Cancelled........Amount was not Collected");
						System.out.println("Thank You");
						return 0;
					}
				} else {
					System.out.println("You Must Pay Before Booking");
				}

				break;
			}
			case 3: {
				System.out.println("Sorry Ur Tickets Cant Be Booked Without Paying............");
				// this.sc.close();
				System.out.println("Do You wish to exit......(y/n)");
				String f = sc.next();
				if (f.equalsIgnoreCase("y")) {
					System.out.println("Please wait .......................... ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					System.out.println("Thank You .......Visit Again");
					System.exit(0);
				}
			}
			}

		} while (true);
	}
	private int getUserChoice() {
		boolean isNumber = true;
		int choice = 0;
		try {
			choice = Integer.parseInt(this.sc.nextLine());
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		while (!(choice > 0 && choice <= 11 || !isNumber)) {
			System.out.println("Choice must be 1 to 11 only");
			try {
				choice = Integer.parseInt(this.sc.nextLine());
			} catch (NumberFormatException e) {
				isNumber = false;
			}
		}
		return choice;
	}
	private int getUserChoice2() {
		boolean isNumber = true;
		int choice = 0;
		try {
			choice = Integer.parseInt(this.sc.nextLine());
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		while (!(choice > 0 && choice <= 3 || !isNumber)) {
			System.out.println("Choice must be 1 to 3 only");
			try {
				choice = Integer.parseInt(this.sc.nextLine());
			} catch (NumberFormatException e) {
				isNumber = false;
			}
		}
		return choice;
	}
	private int getUserChoice1() {
		boolean isNumber = true;
		int choice = 0;
		try {
			choice = Integer.parseInt(this.sc.nextLine());
		} catch (NumberFormatException e) {
			isNumber = false;
		}
		while (!(choice > 0 && choice <= 6 || !isNumber)) {
			System.out.println("Choice must be 1 to 6 only");
			try {
				choice = Integer.parseInt(this.sc.nextLine());
			} catch (NumberFormatException e) {
				isNumber = false;
			}
		}
		return choice;
	}
	private boolean checkContainDigits(String phoneNo) {
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher(phoneNo);
		boolean isvalid = matcher.matches();
		return isvalid;
	}
	private boolean checkValidDate(String date) {
		if(date.trim().equals("")) {
			return false;
		}else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			try {
				Date d=sdf.parse(date);
			}catch(ParseException p) {
				return false;
			}
		}
		return true;
	}
	private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
}
