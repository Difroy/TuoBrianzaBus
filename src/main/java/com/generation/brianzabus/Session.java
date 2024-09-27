package com.generation.brianzabus;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.generation.brianzabus.model.entities.Admin;

@Service
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Session
{

	Admin user;

	public Admin getUser() {
		return user;
	}

	public void setUser(Admin user) {
		this.user = user;
	}
	
	
	
	
	
}
