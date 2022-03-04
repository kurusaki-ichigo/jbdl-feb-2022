package com.c_oops.inheritance;

import java.util.List;
import java.util.UUID;

public class UserInfo {

    public boolean isActive;
    boolean isAdmin;
    private String id;
    protected List<String> userRoles;


    public UserInfo(){
        this.id = UUID.randomUUID().toString();
    }

    public UserInfo(boolean isAdmin, List<String> userRoles) {
        this.isAdmin = isAdmin;
        this.id = UUID.randomUUID().toString();
        this.userRoles = userRoles;
    }

}
