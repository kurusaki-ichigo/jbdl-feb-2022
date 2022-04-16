package com.example.L15.L15;


/**
 *
 *
 *
 *   Entites - Books, Student , Author , Order -- > trying to issue a book (rent) , return a book
 *
 *      - wishlist                          (reviews would do)
 *
 *      add books to wishlist
 *
 *
 *      Student     --(wishlist)-----    Book  (as per wishlist)
 *          1 ----------------> N
 *          N ----------------> 1
 *
 *  *        N ----------> N  ()
 *
 *
 *
 *
 *    (Student)                (course_rating)             (Course)
 *    pk -- Id                  fk student_id               pk -- id
 *                              fk course_id
 *                              (rating)
 *
 *
 *
 *      course_rating  -----> course
 *              N <------------- 1
 *          ManyToOne
 *
 *     course_rating  -----> Student
 *      N ---------------> 1
 *          ManyToOne
 *
 *
 */