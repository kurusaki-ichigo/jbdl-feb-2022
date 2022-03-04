package com.a_modifiers.in;

import java.util.List;
import java.util.UUID;

public class UserInfo {

    /**
     * Access Modifiers :
     *  private - only inside the class
     *      |-          setter and getter (public)
     *
     *  public - access it anywhere
     *
     *  protected -
     *  |- public in the same package + child class of different sub package
     *
     *  default -
     *  | with the package
     *
     *
     */
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
