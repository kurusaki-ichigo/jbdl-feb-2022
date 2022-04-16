package com.example.L13.L13.models;


/**
 *      Entites - Books, Student , Author , Order -- > trying to issue a book (rent) , return a book
 *
 *
 *      Book N-------1 Student      (manyToOne with respect to book but oneToMany with respect to Student)
 *
 *      Book N---------1 Author (1 book has one author but 1 author can have many books) --- (same as above)
 *
 *      Order
 *
 *      Order N--------1 Student
 *     (Order N---------1 Book)                 ----> this would enable ledger
 *
 *
 *
 *     foregin key
 *      --> reference
 *      ---> primary key of other table
 *
 *      Book (id, isbn , name)                      author (id , name , email)
 *
 *      Book (B1 , isbn1, name1, A1, auth_name1, auth_email1)
 *      Book (B2 , isbn2, name2, A2, auth_name2, auth_email2)
 *      Book (B3 , isbn3, name3, A1, auth_name1, auth_email1)
 *
 *      __ the data is not normalized
 *      (1NF , 2 NF , 3NF, BCNF)
 *
 *      Either this
 *          1)
 *      Book (B1 , isbn1, name1, A1)                    (A1, auth_name1, auth_email1)
 *      Book (B2 , isbn2, name2, A2)                    ( A2, auth_name2, auth_email2)
 *      Book (B3 , isbn3, name3, A1)
 *
 *      OR
 *
 *          2)                                                                                   (composite key) -- manyToMany
 *      Book (B1 , isbn1, name1)                    (A1, auth_name1, auth_email1)                  (A1, B1)
 *      Book (B2 , isbn2, name2)                    ( A2, auth_name2, auth_email2)                  (A2, B2)
 *      Book (B3 , isbn3, name3)                                                                    (A1, B3)
 *
 *
 *      1) they all share ----- ahhhh --- something not audible --- ?
 *         varun) reduce the no of joins -- how ? --- for every book we will have reference and we do not have any table
 *         rupali) one book has one author -- foreign key with author better
 *
 *         index --- ? an index is .. what are different types of index --
 *        (tushar) Primary key --> how it behaves --> BTree
 *
 *     2)
 *
 *
 *
 *      book has foreign key author_id ()               author (id)
 *
 *
 *      Order N----------1 User
 *      Order - ManytoOne user
 *      User - onetoMany order
 *
 *
 *      Order ---------- Books
 *      Order to books
 *      1 --------- 1 book (many to many to later)
 *      Book --- Multiple orders (  Book to order single relationship --- @Audited)
 *
 *
 *
 *
 *
 *
 *      -------> Distributed lock
 *      ---> user recharges his wallet
 *
 *
 *
 *      --> payment gateway (orderId , success)
 *
 *
 *      ----> multi instance of the spring boot app.  100,000
 *            --->  (I1) / order/ status (acquire a distributed lock)
 *                         T1 \___> check order id , move it from pending to success , update wallet by order amount and return ok.
 *
 *            --->  (I2) / order /status
 *                          T2 \___> check order id , move it from pending to success , update wallet by order amount and return ok.
 *                          ---> push it to queue to be processed - 10 mins from now
 *
 *                          (redis it down) -- > what would happend
 *             (acquire a distributed lock -- unique orderRefernce --> redis -- ttl --> orderReference)
 *
 *       1000 +  100,000 +  100,000 = twice ? if you do not add proper check
 *
 *      Order was initially in pending state
 *          Order
 *          (233b237f-91d1-4ad9-9486-34cef84d4481 | PENDING | 100,000 | 1 (version))
 *
 *
 *
 *          --> T1 -- update order set orderStatus = SUCESS , version++ where orderReference="233b237f-91d1-4ad9-9486-34cef84d4481" and version=1
 *
 *            (233b237f-91d1-4ad9-9486-34cef84d4481 | SUCESS | 100,000 | 2 (version))
 *
 *          --> T2 -- update order set orderStatus = SUCESS , version++ where orderReference="233b237f-91d1-4ad9-9486-34cef84d4481" and version=1
 *            (233b237f-91d1-4ad9-9486-34cef84d4481 | SUCESS | 100,000 | 2 (version))
 *
 *            throw Optimistic lock exception
 *
 *      /order/status (orderReferenceId , success/ failed){
 *
 *      }
 *
 *
 *
 *
 *
 *
 *
 */