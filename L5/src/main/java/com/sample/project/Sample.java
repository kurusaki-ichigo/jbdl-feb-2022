package com.sample.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sample {

    /**
     *
     * Maven is able to resolve the dependency
     *
     *      3 ways
     *          ------> local repository
     *          -------> central repository
     *          ------> remote  repository
     *
     *          ---> if it has been present in the local
     *                          ----> if yes                ---ok
     *                          ---> if no
     *                                  -------------------------> remote repository
     *                                                  ---------> if yes                   --- ok ------> add that
     *                                                  to local
     *                                                          -- if no
     *                                                                  ------------------------> central repository
     *                                                                      --- if yes      --- ok              to local
     *                                                                      --- if not      -- throw an error
     *
     *
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");

        Statement statement = connection.createStatement();

        statement.execute(" create table sample_info ( id int(10) primary key , " +
                                  " user_roles JSON DEFAULT NULL , " +
                                  " name  VARCHAR (50) DEFAULT NULL )");

    }
}
