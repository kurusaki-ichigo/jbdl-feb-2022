package com.b_similar;

import com.a_modifiers.in.UserInfo;

import java.util.List;


/**
 *  Java does not support similar methods
 *      -- methods with same name
 *          And
 *       -- methods having same type of args ( number and type should be similar)
 */
public class SimilarMethods extends UserInfo {

    private String language;




    public boolean isJavaSupportingSimilarMethods(String language){
        return false;
    }

    //TODO : uncomment below and the compiler error will be visible
//    public boolean  isJavaSupportingSimilarMethods(String id){
//        return true;
//    }

    /**
     * {@link #isJavaSupportingSimilarMethods(String, List)}
     * @param id
     * @param userRoles
     * @return
     */
    public boolean isJavaSupportingSimilarMethods(String id , List<String> userRoles){
        return false;
    }


    public boolean isJavaSupportingSimilarMethods(List<String> userRoles, String id){
        return false;
    }

}
