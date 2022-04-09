package com.example.l12.L12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L12Application {

	/**
	 *          Disadvantages of using adhoc way
	 *              --> its more prone to error
	 *              (1) - in terms of maintainence / addtion of new columns
	 *              (2) - in terms of converstion from java to sql table or vice versa
	 *         (3) maintaion connects / connection pool
	 *
	 *	SpringBoot Application											MySQL (relation)
	 *	Server															Server
	 * UserInfo 														user_info
	 * 	id																id
	 * 	name															name
	 * 	email															email
	 * 	address
	 * 	phoneNumber
	 *  		this mapping of SBServers Pojo -----> MySql server table (explicity by us)
	 *
	 *	Abstract layer ( mapping of entity --> server table mapping)
	 *		(Hibernate)
	 *			---_> ORM tool (Object relational mapping)
	 *
	 *	Hibernate
	 *	Spring-data-starter-jpa
	 *	Spring data jpa
	 *
	 *
	 *
	 *
	 *
	 *

	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(L12Application.class, args);
	}

}
