package com.example.L7.L7;

import com.example.L7.L7.controller.OnboardingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L7Application {

	public static void main(String[] args) {
		SpringApplication.run(L7Application.class, args);
		System.out.println("Inside Main");

//		OnboardingController controller = new OnboardingController();
//		controller.getAllUsers();


	}

}
