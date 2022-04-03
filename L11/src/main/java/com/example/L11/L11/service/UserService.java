package com.example.L11.L11.service;

import com.example.L11.L11.model.enities.UserInfo;
import com.example.L11.L11.model.requests.CreateUserRequestDto;
import com.example.L11.L11.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * <p>
     *     This method is used to create / persist new user object
     * </p>
     * @param userRequestDto
     * @return - userInfo without Id
     */
    public UserInfo createUser(CreateUserRequestDto userRequestDto) {
        UserInfo userInfo = userRequestDto.toUser();
        userRepository.persistUserInfo(userInfo);
        return userInfo;
    }


    public List<UserInfo> fetchAllUsers() {
        return userRepository.fetchAllUsers();
    }

}
