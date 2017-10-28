package com.example.dummy;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Config extends SpringBootServletInitializer {

	public static void main(String[] args) {

		new Config().configure(new SpringApplicationBuilder(Config.class)).run(args);
	}

	@Component
	static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			this.packages("com.example.api");
		}
	}

}