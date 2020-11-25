package com.hzy;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Springboot12AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot12AdminServerApplication.class, args);
	}

}
