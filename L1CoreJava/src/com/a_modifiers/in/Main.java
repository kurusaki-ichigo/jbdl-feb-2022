package com.a_modifiers.in;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        UserInfo userInfo = new UserInfo();
        /**
         * able to initialize roles (protected)
         */
        userInfo.userRoles = Arrays.asList("EMPLOYEE", "ADMIN");
        /**
         * initialize admin (default)
         */
        userInfo.isAdmin = false;
        /**
         * initialize active (public)
         */
        userInfo.isActive = true;
        /**
         * unable to initialize private
         *
         */
        //TODO : uncomment below to see the changes
//        userInfo.id = UUID.randomUUID().toString();
    }
}
