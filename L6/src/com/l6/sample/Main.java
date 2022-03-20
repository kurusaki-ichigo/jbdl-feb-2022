package com.l6.sample;

public class Main {



    /**
     *
     * apple.com / amazon.com  (connected to internet)
     *  at any time interval t == these applications are still runnning..
     *
     *  --> jvm does not exit... (does not call system .exit )
     *
     *  A program which is continuously running / available 24 x 7
     *   --- server....
     *
     *
     *
     *
     *
     *
     *   (server -- web server vs application server )
     *   --web server is designed to render static content -- (other content is also delivered)
     *
     *
     *
     *
     *   User ----> Front End -------> Backend
     *
     *   Ecosystem comprises of FE and BE
     *
     *   User ------->    FrontEnd --> Android App | web app | IOS app  ---> Backend (response)
     *
     *   Responsibilities of the FrontEnd
     *                  ---> UI / UX designing
     *                  --> validation of input as well as taking response from Backend and rendering it.
     *
     *  Responsibilities of the Backend
     *                  --> receiving the request (processing it )
     *                  --> supporting persistence layer (Db -- mysql , mongo etc --
     *                  triggering an event and so on.. )
     *                  ---> returning the response
     *
     *
     *  Spring boot --> a framework
     *              ---> java , groovy , kotlin
     *
     *
     *    Server -->
     *
     *
     *    Tomcat (Apache) ----------------------(60-70) this is widely used
     *    Jetty (Eclipse)       -----------------------
     *    Undertow (Redhat community)
     *
     *    Tomcat vs Jetty -- tomcat -- Servlets 4.0 -- which adapted to it
     *                     -- jetty -- dependent on the users request -- Jenkins -- ? (is packed by default
     *                     standalone jetty for the continuous integration tool )
     *
     *
     *    Spring boot
     *          ----> how application were built  ?
     *
     *
     *          Client ------>-> server [basically running ] ---Connection pool with the application--> Java application
     *
     *          Client --> [Java application
     *                          -- embedded server (tomcat)
     *                      ]
     *
     *
     *          Spring vs Spring Boot
     *                                          ---> AutoConfigurations which have been added
     *         --> stand-alone server           ---> its embedded server
     *         --> xml notations                --> annotations to  configure beans
     *       --> didnt had these privledges    --> H2 (in memory database)
     *      --> configuration                               ---> default configurations specified which lead to easy
     *      bootstrapping of the application.
     *          -- build these configurations manually
     *
     *
     *
     *
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
