package me.biathlonvsu.biathlon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class BiathlonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiathlonApplication.class, args);
	}

}
