package com.a_oops_contd.a_polymorphism.runtime;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Employee extends UserInfo {

    LocalDateTime dateOfJoining;

    public LocalDateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean isActive() {
        return true;
    }

    @Override
    public void setActive(boolean active) {
       this.isActive = active;
    }

    /**
     *
     * UserInfo user1 = new UserInfo();
     * UserInfo user2 = new Employee();
     * Employee emp1 = new Employee();
     *
     * @param args
     */
    //    com.a_oops_contd.a_polymorphism.runtime.UserInfo@75bd9247
    public static void main(String[] args) {

        UserInfo userInfo = new UserInfo();
        userInfo.userRoles = Arrays.asList("STUDENT", "ADMIN");
        userInfo.isAdmin = true;

        System.out.println(userInfo);

        Employee employee = new Employee();
        employee.userRoles = Arrays.asList("EMPLOYEE");
//        employee.setActive(true);

        System.out.println(employee.isActive());

        /**
         * parent reference --
         *  -- limiting the scope or restricting the usage
         *
         * unless extra funcitonality being performed by the derived class
         *      -- base class..
         *
         */
        UserInfo user2 = new Employee();

        Map<String, Integer> stringIntegerMap = new HashMap<>();


//        @Secured("user.role == STUDENT || ")
//        PostMapping("/v1/mskmdksm")
//        public ResponseEntioty(@PathParam Student ){
//
//        }
    }




}
