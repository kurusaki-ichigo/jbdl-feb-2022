package com.l6.sample;

public class Basics {

    /**
     *
     *      IP vs DNS
     *
     *      DNS -- anything readable -- (name mapped to an IP)
     *      IP -- is the unique adderss of the server / machine
     *
     https://www.google.com/complete/search?q=amazon.in&cp=0&client=gws-wiz&xssi=t&hl=en-IN&authuser=0&pq=amazon.in&psi=7fM1YqaIPNeXseMPzpapqAQ.1647703022437&ofp=EAE&dpr=2



     https://www.google.com/
     (base url) +

     /complete/search	+ ?
     (api end point -- application program interface)
     API end point -- a contract between FE and BE ..


     q=amazon.in&cp=0&client=gws-wiz&xssi=t&hl=en-IN&authuser=0&pq=amazon.in&psi=7fM1YqaIPNeXseMPzpapqAQ.1647703022437&ofp=EAE&dpr=2
     (Query params)



     sample cab management

     onbaording a user (-- any application that you build)
     GET -- /api/user -- getting a response form the application --> application --



     *   User ----> Front End (UBER) -------(API gateway)  -- akamai (rate limiter / throttler) ----> Backend
     *   ---------> (Load Balancer ) ------> backend application [server is embeded] -->> DB (get the user if
     *   applicable)
     *                                    (return a response to the client)          <---


     POST -- /api/user
     {
     "name" :
     "userRole" :
     "email" :
     }

     -- payment setting would be different for users --> cab driver vs if it is a rider

     -- RIDER (available) not for DRIVER
     POST /pay
     {
     name : "CreditCard" (details are already stored)
     last4Digit : "xxx-5004"
     }
     *
     *
     *  HTTP status code
     *          {
     *              200 =Ok
     *              401 = Unauthorized
     *              500 = internal server error ()
     *              204 = (no content) not found (delete a resorce -- 200 ok (reasource existed and you deleted it))
     *              404 = api resource is not found
     *              201 = Created --> when a resorce is created
     *              202 = Accepted __ (file --> db(persisted) 1000 records --- batch server --> picking the file and
     *      *              persisting the records)
     *              400 = bad request = { validate a request -- it does not have a necessary param}
     *
     *              2xx - is a kind of success
     *              4xx - is a kind of error
     *              5xx - is server error
     *
     *          }
     *
     *
     *  Use case to study
     *      - Uber Eats launched in India --> and if the user didnt had money in Paytm wallet
     *          -- they were still able to make successful orders..
     *
     *        {
     *        }
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
