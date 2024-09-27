package com.generation.brianzabus.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Admin 
{

	int id;
	String email, password;
	LocalDate lastPasswordChange;

	
	
	
	
	
}
