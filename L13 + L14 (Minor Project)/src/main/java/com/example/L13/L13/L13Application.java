package com.example.L13.L13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L13Application {

	/**
	 * 	Revise
	 * 		---
	 * 		Prepared Statement vs Statement
	 * 		--> useful
	 * 		(statement is compile everytime)
	 * 		(PreparedStatement --> compiled once --added to cache)
	 *
	 * 		--> benefical (Sql injections)
	 *
	 * 	String id = ? --> from RequestParam ( id = 1;delete from user;   )
	 * 		"select * from user where id=" + id
	 * 		"select * from user where id=1;
	 * 			delete from user;"
	 *
	 *
	 * Disadvantages of using adhoc way
	 * 	--->
	 * 			difficult to maintain
	 * 			---- (ResultSet (extract things DB))
	 * 			(we were specifying thing for the query)
	 * 		 ----- PreparedStatement.setInt(1, values);
	 * 		-- Creating a connection per repository
	 * 		(aws instance type / machine = 12000 connections)	---->
	 * 	deploy your jar ---> spring boot appication (multiple instance of the spring boot)
	 * 				---> 200 -250 threads -- paralllel requests that a tomcat server can handle
	 * 				----> (more instance of app needs to be deployed)	---> no of connections would increase
	 * 				(per instance there is connection pool that is being used)
	 *
	 * 		--------------------------------------------------------------------------------------------
	 *
	 * 	spring-boot-starter-data-jpa
	 * 		---- > JPA being an interface
	 * 			(contracts)
	 * 				-- find , save, flush, delete ,
	 *
	 * 	Hibernate does
	 * 		---> implementation for these
	 *
	 *	Sping data jpa
	 * 			JPARepository<Entity , PKey>
	 * 			find (CRUD)
	 *
	 *
	 * 	spring-boot-starter-data-mongodb vs spring-boot-starter-data-casandra
	 *
	 * 			MongoRepository<Document , PKey>
	 *
	 *
	 * 		--------------------------------------------------------------------------------------------
	 *
	 * 	spring-boot-starter-data-jpa
	 * 		|
	 * 		jakarta.persitence.api =  sql related stuff @Table @Id @Column
	 * 		|
	 * 		spring-data-jpa =  provides contract for the db operations
	 * 		|
	 * 		hibernate-core = ORM (object relational mapping)
	 * 				maps entity object to table
	 * 			framework for implementation of spring-data-jpa
	 *
	 * 		--------------------------------------------------------------------------------------------
	 *
	 * 	pagination
	 * 		--> tripadvisor
	 *
	 * 	hiberate --> sql entites
	 * 		spring.jpa.hibernate.ddl-auto = update ? create ? create-drop ? none
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(L13Application.class, args);
	}

}
