package com.a_modifiers.out;

import com.a_modifiers.in.UserInfo;

import java.util.Arrays;

public class ChildClassOfDifferentSubPackage extends UserInfo {

    /**
     * testing
     * @param args
     */
    public static void main(String[] args) {
        ChildClassOfDifferentSubPackage child = new ChildClassOfDifferentSubPackage();
        child.checkProtectedAccessModifier();
        System.out.println(child);
    }

    public void checkProtectedAccessModifier() {
        this.userRoles = Arrays.asList("CHILD", "PARENT");
    }


}
