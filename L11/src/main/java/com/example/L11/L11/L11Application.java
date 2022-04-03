package com.example.L11.L11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class L11Application {

	/**
	 *
	 *
	 * Database Connectivity
	 *
	 * 	--> what is a db ??
	 *
	 * 	layman :
	 * 		---> storage for data
	 *
	 * 	Why is it required ?
	 * 		------> to access data at future / later
	 *
	 * 	---------------------------------------------------------------
	 *
	 * 	In memory (h2 -- sql)
	 *
	 * Till now
	 * 	Used as datastore -- as hashMap <key >, <Value>
	 * 	    And we created -- spring boot application
	 *
	 * 	    What will happen if your application would crash -- ?
	 * 	    	(data which is present in memory will  be lost)
	 *
	 *
	 * 	   Amazon.com
	 * 	   9 PM IST -------------> order was expected to be delivered --> tomorrow
	 *		----> user ---> placed an order --> earphones (apple airpods) --> memory
	 *
	 *		(pod / application) ----> crash ??? ------> such order would no longer exists
	 *				---> order is placed in memory --> and if the pod crashes , order is no longer available
	 *
	 *
	 *	(DB) -- storage unit
	 *				-------------> Relational
	 *						MySql , H2 (in memory --- generally to test components test / unit test)
	 *						Oracle , Postgres, SQL Server , Coackrach DB
	 *
	 *					(ACID - Atomicity , COnsistency , Isolation , Durability)
	 *				(Transaction Management)
	 *			(Payment)
	 *
	 *	(vitess -- read around it ---> this was created by folks from youtube -- when they were facing issues
	 *with mySQL configuring replica's and dr's	)
	 *				------------> non relational  (7)
	 *					MongoDb (4.2 + provides ACID properties)
	 *					Cassandra (---> where it is used ----> generally when you have billions of inserts)
	 *				Dynamo DB (ACID properties)
	 *
	 *					(do not offer -- ACID -- ?)
	 *						(yes) - 4 	(yes)
	 *						(no) - 3
	 *
	 *	(Disaster Recovery)
	 *		(us-east-1 -- N. Virginia)
	 *		(DB) (master) (replica)
	 *
	 *
	 * (this is down)
	 *		(ap-south-1 , Mumbai)
	 *		(DB)	(master) --> caught on fire ()
	 *
	 *
	 * 	Spring MVC
	 * 		---->
	 * 			M : Model
	 * 			V : View
	 * 			C: controller
	 *
	 *
	 * 	tomcat --> (dispatcherServlet) ---> searches for @Contoller (directly / indirectly -->
	 * 	 * 	@RestController)
	 *																D-Data , Access object
	 * 				  ResourceMapping		BusinessLogic			(DAO layer)
	 * 	FrontEnt ----> 	[@Controller] -----> [@Service] --------->[@Repository] --------> (Datasource)
	 * 				-																			((()))
	 *																			(Models/Entites)|__|
	 * 	(View)
	 *
	 *
	 *
	 *	Data Manipulation Language (DML)
	 * 	DDL -- Data Definition  Language
	 *
	 *	-- creating
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(L11Application.class, args);
	}

}
