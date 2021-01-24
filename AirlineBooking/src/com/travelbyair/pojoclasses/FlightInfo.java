package com.travelbyair.pojoclasses;

public class FlightInfo {
	public FlightInfo(){
	}
	public FlightInfo(int flightid, int seat, float ticket_cost, String source, String destination,
			String service_provider, String journey_date, String departure_date, String arrival_time) {
		super();
		this.flightid = flightid;
		this.seat = seat;
		this.ticket_cost = ticket_cost;
		this.source = source;
		this.destination = destination;
		this.service_provider = service_provider;
		this.journey_date = journey_date;
		this.departure_date = departure_date;
		this.arrival_time = arrival_time;
	}
	private int flightid,seat;
	private float ticket_cost;
	private String source,destination,service_provider,journey_date,departure_date,arrival_time;
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public float getTicket_cost() {
		return ticket_cost;
	}
	public void setTicket_cost(float ticket_cost) {
		this.ticket_cost = ticket_cost;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getService_provider() {
		return service_provider;
	}
	public void setService_provider(String service_provider) {
		this.service_provider = service_provider;
	}
	public String getJourney_date() {
		return journey_date;
	}
	public void setJourney_date(String journey_date) {
		this.journey_date = journey_date;
	}
	public String getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
}
