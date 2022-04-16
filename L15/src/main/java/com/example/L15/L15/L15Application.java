package com.example.L15.L15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L15Application {

	/**
	 *
	 * 	Authentication
	 * 		----->
	 * 				(a valid login credentials)
	 *
	 * 	vs
	 *
	 * 	Authorization
	 * 				(restricting the access of the user)
	 * 				--> api -- which you do not want to expose to all -- rather a fe
	 *
	 *
	 * 	Zomato
	 * 			---> (user --> role ---> CUSTOMER)
	 * 			---> (user ---> role --> MERCHANT)
	 *		CUSTOMER vs MERCHANT
	 *			---> purchase a product
	 *			---> merchant sells
	 *
	 *		CUSTOMER --> PLACE Order
	 *		MERCHANT --> restaurant owner --> accept the order and prepare it and wrap it
	 *
	 *		CUSTOMER --->
	 *			/ collect payment
	 * @PreAuthorize('hasRole('CUSTOMER')') / @Secured("CUSTOMER") --->
	 *	user but not exposed to merchant  -- POST 	/collect/payment	 (collecting userInformation)
	 *
	 * @PreAuthorize('hasRole(CUSTOMER) or hasRole('MERCHANT')')
	 *	merchant/customer -- GET 	/payment/status
	 *
	 *			/ receive payment
	 *
	 *
	 * Cookie
	 * 	---> data sent by a backend -- which will store some meta information
	 * 		---> SESSION_ID -- ()
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(L15Application.class, args);
	}

}
