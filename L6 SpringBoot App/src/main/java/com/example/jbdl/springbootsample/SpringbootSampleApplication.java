package com.example.jbdl.springbootsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSampleApplication {

	/**
	 * output
	 *  Console -- printed (1) or not (2)
	 * (3) application will stop after 1
	 * (4) application will continue to run
	 *
	 *
	 * 	print statement
	 * 	1
	 * 	2
	 * 	4
	 * 	3
	 *
	 *	a lot of auto configurations
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSampleApplication.class, args);
		System.out.println("hey .. I am doing just fine before I met you ");

	}

}
