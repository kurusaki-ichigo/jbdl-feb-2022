package com.example.cache.cache;


/**
 *
 *
 *  Caching required -->
 *
 *  Tinyurl
 *
 *          url shortner
 *              (big url ) ----> convert into short url -
 *
 *
 *
 *      convert into short url --> redirected to bigger one
 *
 *  where it would be used -->  ?
 *  SMS application
 *      ---> limit per characters of the message --> tweets , sms
 *
 *
 *      tweets ---> length -- 50 charcter
 *      Db schema
 *          --> for it
 *
 *          {
 *              bigurl :  ()
 *              tinyurl (length limit) : (characters should we allow) --- (10 characters)
 *              created_at:
 *              updated_at:
 *          }
 *
 *
 *      lets say that average tps - transactions per seconds / qps - queries per second
 *      This application - read heavy or write heavy --> write data --> database
 *      (Read Heavy ---> defintitely )
 *      (Write Heavy-->   not so much )
 *
 *      create new tinyurl
 *      Write --> insert into db.table  (bigurl, tinyurl, now(), now())
 *      --> return tinyurl
 *
 *
 *      click on tinyurl
 *      fetch --> select bigurl from db.table where tinyurl=""
 *
 *
 *      create new tinyurl <<<<< click on tiny
 *          1:20 (average usecase)
 *          spike can max be 1:20 * (5) -- 1:100 would be the kind of traffic
 *
 *          how many requests -- in a hour / request per day --> 10K request per hour --> write
 *          24 hours
 *          365 days
 *`                     86 700 000 = 86 million new urls  |
 *      My assumptions : lets day we can have upto 1 year -- not more than than
 *
 *                   86 million new urls  - tiny urls created
 *                   (char) - combinations -- (0-9a-zA-Z)
 *                   62 combinations
 *                   = 2 character combination -- ? (62)*(62) = (62) square
 *
 *
 *                   (62) to power n = 90 million
 *                   what the value of N = 10
 *
 *                 218 340 105 584 896
 *
 *
 *
 *                 System that I am  bulding
 *                 86 million inserts are already there * (5)  = 430 mil
 *
 *                 1:100
 *
 *                 1300 tps = (86 million rows )
 *  *                  fetch --> select bigurl from db.table where tinyurl=""   (unique index) huge time
 *
 *
 *              we require caching
 *                  (retrieving data from becomes expensive)
 *
 *                 (Trie -- Data structure, Homework -- Please let me know how phonebook is implemented)
 *
 *
 *
 *                 fe (tiny url) --------------- Springboot app ----------(Mysql - (32MB increase this ram)
 *                                                                                  RAM and would have DISK -- SATA -
 *                                                                                  SSD (flash drives))
 *
 *                                                                                  Increase your operational cost
 *                 latency --> time requrired to perform an operation
 *                 how we can improve it
 *
 *
 *
 *
 *                 What else we can do --> ?
 *                 (Springboot app -- Use here a hashMap) -- do you want to store all the information here in hashMap
 *                 hot keys
 *                  -----> hot (things that you are creating ---> hot with respect to created_at)
 *
 *                  Managing things on your own --> becomes difficult (hashMap) ---> caching mechanism in jvm
 *                  JVM cache
 *                  its  not distributed in nature ()
 *
 *
 *   Load Balancer (redirection to userId basis)          (1)    (Springboot app - I1 jvm )                (3)   Database (master)
 *
 *                                                                  (Springboot app - I2 )                      Database (slave)
 *
 *                                                               (Springboot app - I3)
 *
 *
 *
 *
 *                                                       (2)   Distributed Cache
 *                                                 Redis         (url1 , bigurl1)           ---> Aerospike
 *
 *
 *                  and so on (scaling depends on various configurations --> CPU utilization (70%) && memory)
 *
 *                  Cache Miss --> when you do not have data pertaining to the cache key and you load it form Db
 *                  Cache Hit ---> not CacheMiss
 *
 */