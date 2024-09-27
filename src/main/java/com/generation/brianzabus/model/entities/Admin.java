package com.generation.brianzabus.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
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

	public List<String> getErrors() {

		List<String> res = new ArrayList<String>();
		{
			if (!hasValidEmail())
				res.add("Invalid email");

			if (!hasValidPassword()) {
				res.add("Invalid password");
			}

		}
		return res;

	}

	private boolean hasValidPassword() {

		return password!=null  &&
				!password.isBlank()&&
				password.length()>=6 &&
				password.length()<=15 &&
				containsUpper() &&
				containsLower() &&
				containsNumbers() &&
				containsSpecial();	
	}

	
	private boolean containsLower() {
		
		for (int i = 0; i< password.length();i++)
			if (password.charAt(i)>= 'a' && password.charAt(i)<='z')
				return true;
		return false;
			
	
	}

	private boolean containsUpper() {

		for (int i = 0; i< password.length();i++)

			if (password.charAt(i)>= 'A' && password.charAt(i)<='Z')
				return true;
		return false;
		
	}
	
	
	private boolean containsSpecial()
	{
		Set<Character> special = new HashSet<Character>();
		
		special.add('.');
		special.add('_');
		special.add('-');
		special.add('!');
		special.add('?');
		
		for (int i=0; i<password.length();i++)
			if(special.contains(password.charAt(i)))
				return true;
		return false;
	}
	
	private boolean containsNumbers()
	{
		for (int i=0; i<password.length();i++)
			if(Character.isDigit(password.charAt(i)))
				return true;
		return false;
		
			
	}
	
	
	

	private boolean hasValidEmail() {
		// deve esserci una sola @
		// username@dominio
		return hasValidStructure() && hasValidUsername() && hasValidDomain();

	}

	private boolean hasValidDomain() {
		String domain = email.split("@")[1];
		return onlyValidCharacters(domain) && domain.indexOf(".") > 0;

	}

	private boolean hasValidStructure() {

		if (email == null || email.isBlank())
			return false;
		String[] parts = email.split("@");

		if (parts.length != 2)
			return false;
		if (parts[0].length() == 0 || parts[1].length() == 0)
			return false;
		return true;

	}

	private boolean hasValidUsername() {

		String username = email.split("@")[0];

		return notANumber(username.charAt(0))

				&& onlyValidCharacters(username);

	}

	private boolean onlyValidCharacters(String s) {
		String valid = "0123456789ABCDEFGHILMNOPQRSTUVZXYWJKabcdefghilmnopqrstuvzwkjyx.";
		Set<Character> chars = new HashSet<Character>();
		for (int i = 0; i < valid.length(); i++)
			chars.add(valid.charAt(i));

		for (int i = 0; i < s.length(); i++)
			if (!chars.contains(s.charAt(i)))
				return false;

		return true;

	}

	private boolean notANumber(char f) {
		return !(f >= '0' && f <= '9');
	}
}

/*
 * List<String> res = new ArrayList<String>();
 * 
 * if (email == null || email.isEmpty() || !email.contains("@") ||
 * !email.contains(".")) { res.add("Email is required"); } if
 * (!email.matches("[A-Za-z0-9._-!?]")) { res.add("Email is not valid"); }
 * 
 * if (password == null || password.isEmpty()) {
 * res.add("Password is required"); }
 * 
 * 
 * 
 * return res;
 * 
 */

// deve avere email e l'email deve essere valida
/*
 * deve avere lastPasswordChange la password deve contenere maiuscolo e
 * minuscolo minimo 6 caratteri, massimo 15 deve conteneri almeno un numero deve
 * contenere almeno un carattere speciale fra .!?_-
 * 
 * 
 */
