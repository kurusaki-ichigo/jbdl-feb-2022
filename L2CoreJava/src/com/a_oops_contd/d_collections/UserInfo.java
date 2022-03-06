package com.a_oops_contd.d_collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class UserInfo {

    public String name;
    protected List<String> userRoles;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(userRoles, userInfo.userRoles);
    }


    @Override
    public int hashCode() {
        return Objects.hash( userRoles);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name=" + name +
                ", userRoles=" + userRoles +
                '}';
    }

    public static void main(String[] args) {

        /**
         * internal working of HashMap
         *
         *
         *   key , value -- hash of key == is h1
         *    key2 , value   -- hash of key2 == is h2
         *    key3 , value   -- hash of key3 == is h1
         *
         *   key , value2   -- hash of key == is h1

         *  generate the hash of the (key)
         *          |
         *        step 1  _______> bucket to go to  h1
         *        step 2 ----> check if any array / list is present
         *                 |_____>       iterate over the list and check if the key is equal to the node key
         *                                  ---> if yes === update value
         *                                  ----> if no == insert / append at the last
         *
         *    --------------------------------------------
         *    |       h1      |               |    h2       |
         *    -----------|--------------------------------
         *          LinkedList
         *
         *    --------------------                 -----------------
         *    |        key , value2   |                  key2 , value
         *    -----------|-------                   ------------------
         *    --------------------------
         *    |         key3 , value     |
         *    -----------|--------------
         *
         */


        UserInfo userInfo = new UserInfo();
        userInfo.name = "John Cena";
        userInfo.userRoles = Arrays.asList("WRESTLER");


        UserInfo userInfo2 = new UserInfo();
        userInfo2.name = "Rock";
        userInfo2.userRoles = Arrays.asList("WRESTLER");

        Map<UserInfo, Integer> userInfoCountMap = new HashMap<>();
        userInfoCountMap.put(userInfo, 3);

        System.out.println(userInfoCountMap);

        System.out.println("The equals " +  userInfo.equals(userInfo2));

        userInfoCountMap.put(userInfo2, 10);
        System.out.println(userInfoCountMap);

//        System.out.println(userInfo.hashCode() + "   " + userInfo2.hashCode());





    }
}
