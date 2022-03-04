package com.a_modifiers.out;

import com.a_modifiers.in.UserInfo;

public class Main {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        /**
         *  initialize active (public access modifier)
         */
        userInfo.isActive = false;
        //TODO : uncomment the below and check they do not work
//        userInfo.isAdmin = false;
//        userInfo.userRoles = new LinkedList<>();
    }
}
