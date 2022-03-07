package com.a_functional_interface.b_example;

public class CompareByName {

    public int compareByName(UserInfo u1 , UserInfo u2){
        return u1.getName().compareToIgnoreCase(u2.getName());
    }

}
