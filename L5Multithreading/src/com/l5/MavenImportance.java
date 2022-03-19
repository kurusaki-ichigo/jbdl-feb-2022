package com.l5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MavenImportance {


    /**
     * <p>
     *     MSQL - DB
     *      -- relational DB
     *
     *   need for the maven
     *          --> try creating a sample table using JAVA
     *
     *
     *   JDBC --- Java Database Connectivity -- Protocol
     *              ----> browser == http:
     *              --> transfer files == ftp (file transfer protocol)
     *              -->Mail from sender to receiver === SMTP
     *
     *
     *
     *
     *
     *
     *
     * </p>
     *
     * @param args
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            //jdbc:subprotocol:subname
        /**
         * port for mysql - 3306
         * postgres - 5432
         *
         * UserInfo {
         *     int id primary key,
         *     varchar(50) user_roles,
         *     varchar(50) name;
         * }
         *
         *
         */

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");

        Statement statement = connection.createStatement();

        statement.execute(" create table delta_info ( id int(10) primary key , " +
                                  " user_roles JSON DEFAULT NULL , " +
                                  " name  VARCHAR (50) DEFAULT NULL )");

        /**
         * analogy
         * String -- varchar vs text
         * List or map --- JSON
         * Integer -- int
         * Boolean -- bool  tiny int(1)
         *
         */

        /**
         * Adding / configuring manually each time
         *  - not scalable
         *  - its more error prone
         *  -> kafka --- zookeeper
         *  -- dependency --> other dependency required --
         *
         *
         */


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
    }
}
