package com.a_oops_contd.a_polymorphism.runtime;

import java.util.List;

public class UserInfo {

    boolean isActive;
    boolean isAdmin;


    protected List<String> userRoles;

//    public UserInfo(boolean isActive, boolean isAdmin, List<String> userRoles) {
//        this.isActive = isActive;
//        this.isAdmin = isAdmin;

    @Override
    public String toString() {
        return "UserInfo{" +
                "isActive=" + isActive +
                ", isAdmin=" + isAdmin +
                ", userRoles=" + userRoles +
                '}';
    }
//        this.userRoles = userRoles;
//    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

    public UserInfo() {
    }
}
