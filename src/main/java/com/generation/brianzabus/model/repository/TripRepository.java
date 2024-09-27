package com.generation.brianzabus.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.brianzabus.model.entities.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {

}
