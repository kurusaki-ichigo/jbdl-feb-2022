package com.a_functional_interface.b_example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserInfo {

    String name;
    Double id;

    public UserInfo(String name) {
        this.name = name;
        this.id = Math.random();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }



    public static int compareById(UserInfo p1 , UserInfo p2){
        return p1.getId().compareTo(p2.getId());
    }



    public static void main(String[] args) {
        List<UserInfo> userInfoList = new LinkedList<>();
        /**
         * (args) -> {body}
         */
        Collections.sort(userInfoList, (p1, p2) -> {
             return p1.getId().compareTo(p2.getId());
        });


    }


}
