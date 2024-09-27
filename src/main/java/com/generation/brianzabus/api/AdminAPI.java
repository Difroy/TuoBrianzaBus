package com.generation.brianzabus.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.brianzabus.Session;
import com.generation.brianzabus.model.entities.Admin;
import com.generation.brianzabus.model.repository.AdminRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/bb/api/admin")
public class AdminAPI {

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	Session session;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Admin admin)
	{
		Admin found = adminRepo.findByEmailAndPassword(admin.getEmail(), admin.getPassword());

		if (found != null)
		{
			session.setUser(found);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.status(403).build();

	}

	@PostMapping("/logout")
	public ResponseEntity<Object> logout()
	{
		session.setUser(null);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	

}
