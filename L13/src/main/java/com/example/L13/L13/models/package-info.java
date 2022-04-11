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
 *
 */