package com.example.L13.L13;


/**
 *
 *
 *      Minor project 1
 *
 *      Chegg.com
 *
 *      1)  Entities
 *      2) funcationalities
 *      3) Relationship or Cardinality
 *      4) HLD
 *
 *      Entites - Books, Student/UserInfo , Author , Order -- >  {trying to issue a book (rent) , return a book}, purchase a book
 *
 *      functionalities =
 *          ---> search a book by name , isbn
 *          ---> transactions made in last 30 days (later)
 *          -->  trying to issue a book (rent) , return a book
 *          --> fine if you exceed return period
 *          --> reviews (if time allows)
 *          --> max books to rent
 *
 *
 *  Not having this as of now as I want the ledger
 *  *     Order 1---------1 Book (active order)       ---> this would only provide the current snapshot
 *
 *      (H.W. -- @Audited  ---> envers , distributed transactions (@Version))
 *      Order 1---------1 Book (active order)  + @Audited  ---> envers   ---> this would provide complete ledger
 *
 *
 *
 *      Relationship / Cardinality
 *      (many to many)
 *
 *      Unique book ----> more than one student (yes / no)
 *      `1:1
 *
 *      Can one student issue more than one books at a time (max capacity -- 15)
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
 *
 *
 *
 *
 *
 *         Rest api + mysql + spring data jpa
 *      (same -- my code as reference --- you  can do similar stuff)
 *      --> implement
 *
 *
 *
 *      (i = count of letters in the first name % 2)
 *      (0) = Parking Lot
 *      (1) = Snake And Ladder
 *
 *
 *     Minor project 2
 *         Rest api + mysql + spring data jpa + spring security + redis as cache
 *          (jvm cache)
 *
 *          where redis vs jvm cache
 *
 */