package com.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloController {

	@GET
	@Path("/world")
	public String trial() {
		return "hello world";
	}

	@GET
	public String message() {
		return "Hello ";
	}

	
	
}