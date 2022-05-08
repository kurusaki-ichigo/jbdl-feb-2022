package com.example.sample.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {



	/**
	 *
	 * 	Uber
	 *
	 *
	 *	Authentication
	 * 		----->
	 * 			user is valid or not
	 *	-- whether a user is present or not
	 *				---> rider 	(user)			---> would not have permission to start a trip
	 *				---> driver (user)			---> would have permission to start a trip
	 *
	 *
	 * 	Pratical usecase of UBER
	 *	riders
	 *		--> get OTP
	 *		--> get ride details including drivers
	 *		--> payment
	 *		--> booking a ride
	 *
	 *	drivers
	 * 		-->  start a trip
	 *		--> validate OTP (trips)
	 *		--> withdraw money to your bank account
	 *		--> send trip data
	 *		--> accept a ride
	 * 	vs
	 *
	 *
	 *
	 * 	Practical usecase of S2S authentication
	 *
	 *	book my show
	 *
	 *		/book (microservice)
	 *
	 * 		/payment (which will integrate with various third party aggregators)
	 *
	 * 		/invoice (microservice) --> responsible for generating invoices for a user
	 * 			---> generating invoices for merchants (PVR / places that host movie)
	 * 			--> reconcilation --> (no of tickets book my show sold (book my show db)=== no of tickets (3rd part db) )
	 *
	 * 	/cart (microservice) ---> payment to get the booking information and payment information (purchase history)
	 * 			--> ticket --> payment information
	 *
	 *
	 *
	 *
	 *
	 *		Book
	 *		CART			/payment
	 *		INVOICE
	 *		SEARCH
	 *		(--> reconcilation	)
	 *			payments , book , cart
	 *
	 *		Authorization (/payment api --> for BOOK , for CART , INVOICE but NOT FOR SEARCH)
	 *					-- JWT authentication and authorization
	 *
	 *		Front End (while making payment)
	 *
	 *
	 *
	 * 	Authorization
	 * 				roles and permission
	 *
	 *
	 *
	 *
	 * @param args
	 */

	/**
	 * 10- email
	 *
	 * another added
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
