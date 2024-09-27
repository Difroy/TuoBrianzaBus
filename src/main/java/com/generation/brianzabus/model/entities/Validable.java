package com.generation.brianzabus.model.entities;

import java.util.List;

/**
 *Questa interfaccia serve per segnalare che una classe è valida.
 *e per avere metodi concreti e infatti ora ne usufruirò
 * */


public interface Validable {

	
	
	/**
	 * Questo metodo restituisce una lista di stringhe che rappresentano gli errori di validazione.
	 * 
	 * @return
	 */
	List<String> getErrors();
	
	
	/**
	 * Questo metodo restituisce true se l'oggetto è valido, false altrimenti.
	 * 
	 * @return
	 */
	default boolean isValid() {
		return getErrors().isEmpty();
	}
	
	
	
}
