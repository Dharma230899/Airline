package com.BrownField.pss.vo;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class SearchForm {

	private String origin;
	private String destination;
	private String departureDate;	
	private String travelClass;
	private int numberOfPeople;
	@JsonIgnore
	private String adults;
	@JsonIgnore
	private String child;
	@JsonIgnore
	private String infants;
	
	public String getAdults() {
		return adults;
	}
	@JsonIgnore
	public void setAdults(String adults) {
		this.adults = adults;
	}

	

	public String getChild() {
		return child;
	}
	@JsonIgnore
	public void setChild(String child) {
		this.child = child;
	}

	public String getInfants() {
		return infants;
	}
	@JsonIgnore
	public void setInfants(String infants) {
		this.infants = infants;
	}

	public SearchForm() {	
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	@Override
	public String toString() {
		return "SearchForm [origin=" + origin + ", destination=" + destination + ", departureDate=" + departureDate
				+ ", travelClass=" + travelClass + ", numberOfPeople=" + numberOfPeople + ", adults=" + adults
				+ ", child=" + child + ", infants=" + infants + "]";
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	
	
	
}
