package com.movie.domain;

public class Theatre {
	public int theatreId;
	public String theatreName;
	public String location;
	public String phoneNo;
	public int seatingCapacity;
	
	

	public Theatre(int theatreId, String theatreName, String location, String phoneNo, int seatingCapacity) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.location = location;
		this.phoneNo = phoneNo;
		this.seatingCapacity = seatingCapacity;
	}
	
	public Theatre(){
		
	}
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	
	
}
