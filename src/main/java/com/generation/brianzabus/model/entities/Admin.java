package com.generation.brianzabus.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	int id;
	String email, password;
	LocalDate lastPasswordChange;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getLastPasswordChange() {
		return lastPasswordChange;
	}
	public void setLastPasswordChange(LocalDate lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public List<String> getErrors()
	{
		
		
		List<String> errors = new ArrayList<String>();
		
		if (email == null || email.isEmpty() || !email.contains("@") || !email.contains("."))
			errors.add("Email is required");
		if (email.matches("AZaz09._-!?"))
			errors.add("Email is not valid");
	
	
		if (password == null || password.isEmpty());
			errors.add("Password is required");
			if (lastPasswordChange == null)
				errors.add("Last password change is required");
			
		return errors;
		
		
		
		
		
		
		
		
		
		
		//deve avere email e l'email deve essere valida
		/*deve avere lastPasswordChange
		 * la password deve contenere maiuscolo e minuscolo
		 * minimo 6 caratteri, massimo 15 
		 * deve conteneri almeno un numero
		 * deve contenere almeno un carattere speciale fra .!?_-
		 * 
		 * 
		 * */
	}
	
	
	
	
	
	
}
