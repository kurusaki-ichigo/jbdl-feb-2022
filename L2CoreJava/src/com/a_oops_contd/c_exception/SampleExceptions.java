package com.a_oops_contd.c_exception;


/**
 *
 *                                                              Throwable
 *                      -------------------------->                       <---------------------------
 *                      Exceptions --                                                           Error
 *  RunTime                             and Compile Time
 * Or
 *  Unchecked Exceptions                    Checked Exceptions
 * -> Null pointer exception
 * -> RuntimeExceptions                     --> I/O exception
 * -> ArrayIndex Out of bound               --> FileExceptions
 * --> arithmetic exception                 --> DatabaseException - SQL
 * -- class not found
 *  --> class cast
 */
public class SampleExceptions {

    // run time
    public class SampleRunTimeException extends RuntimeException {

    }

    // compile time
    public class SampleCompileTimeException extends  Exception {

    }





}
