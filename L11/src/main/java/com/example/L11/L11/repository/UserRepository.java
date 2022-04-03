package com.example.L11.L11.repository;

import com.example.L11.L11.model.enities.UserInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
@Slf4j
public class UserRepository implements InitializingBean {

    private Connection connection;



    private static final String CREATE_TABLE = " CREATE TABLE IF NOT EXISTS `user_info` (\n" +
            "  `id` int(10) NOT NULL AUTO_INCREMENT,\n" +
            "  `email` varchar(50) DEFAULT NULL,\n" +
            "  `name` varchar(50) DEFAULT NULL,\n" +
            "  `address` varchar(250) DEFAULT NULL,\n" +
            "  `phone_number` int(10) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ")  ";


    private static final String INSERT_INTO_USER_INFO = "insert into user_info(`email`, `name`, `address`, `phone_number`) " +
            "values (?,?,?,?)";


    private static final String FETCH_ALL_USER = "select * from user_info";
    /**
     *
     * @param userInfo
     * @return
     */
    @SneakyThrows
    public UserInfo persistUserInfo(UserInfo userInfo){
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER_INFO);
        preparedStatement.setString(1, userInfo.getEmail());
        preparedStatement.setString(2, userInfo.getName());
        preparedStatement.setString(3, userInfo.getAddress());
        preparedStatement.setInt(4,userInfo.getPhoneNumber());
        int i = preparedStatement.executeUpdate();
        log.info(" inserted the record {} ", i == 1 ? true : false);
        return userInfo;
    }


    @SneakyThrows
    public List<UserInfo> fetchAllUsers(){
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FETCH_ALL_USER);
        List<UserInfo> userInfos = new LinkedList<>();
        while (resultSet.next()){
            UserInfo userInfo = UserInfo.builder()
                    .id( resultSet.getInt("id"))
                    .phoneNumber( resultSet.getInt("phone_number"))
                    .email(resultSet.getString("email"))
                    .address(resultSet.getString("address"))
                    .name(resultSet.getString("name")).build();
            userInfos.add(userInfo);
        }
        return userInfos;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root" , "");
        Statement statement = connection.createStatement();
        boolean execute = statement.execute(CREATE_TABLE);
        log.info(" Create Table Operation - Success :: {}  ", execute);
    }
}
