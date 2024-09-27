package com.generation.brianzabus.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Trip implements Validable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String departure,arrival;
	String description;
	LocalDate date;
	LocalDate departureTime,arrivalTime;
	int capacity;
	int cost;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getDeparture() {
		return departureTime;
	}
	public void setDeparture(LocalDate departure) {
		this.departureTime = departure;
	}
	public LocalDate getArrival() {
		return arrivalTime;
	}
	public void setArrival(LocalDate arrival) {
		this.arrivalTime = arrival;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDate getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	@Override
	@JsonIgnore
	public List<String> getErrors()
	{

		List<String>res = new ArrayList<String>();
		
		if (description == null || description.isBlank())
			res.add("La descrizione non può essere vuota");
		if (date == null)
			res.add("La data non può essere vuota");
		if (departureTime == null && arrivalTime == null)
			res.add("La partenza e l'arrivo non possono essere vuoti");
		if (departureTime != null && arrivalTime != null && departureTime.isAfter(arrivalTime))
			res.add("La partenza non può essere nel passato");
		if (capacity < 10)
			res.add("La capienza minima è di 10 persone");
		if (cost < 0)
			res.add("Il costo non può essere negativo");
		return res;
		
		
		
	}
	
	
	
	
}
