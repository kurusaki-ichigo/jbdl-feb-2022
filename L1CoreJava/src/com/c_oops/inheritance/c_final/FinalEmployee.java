package com.c_oops.inheritance.c_final;

import com.c_oops.inheritance.UserInfo;

import java.time.LocalDateTime;

/**
 * final class
 */
public final class FinalEmployee extends UserInfo {

    // indicating the DOJ for the user
    public LocalDateTime dateOfJoining;
    /**
     * final variable
     * -    Constructor
     *  -   instance block
     *  -   inline
     */
    final int count /* =10 */ ;

//    {
//        count = 10;
//    }

    public FinalEmployee() {
        this.count = 10;
    }


}
