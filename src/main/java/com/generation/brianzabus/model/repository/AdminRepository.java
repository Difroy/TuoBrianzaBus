package com.generation.brianzabus.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.brianzabus.model.entities.Admin;

public interface AdminRepository extends JpaRepository <Admin, Integer> {

}
