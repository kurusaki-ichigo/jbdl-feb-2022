package com.example.L13.L13.service;

import com.example.L13.L13.models.UserInfo;
import com.example.L13.L13.repository.UserRepository;
import com.example.L13.L13.requests.CreateUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        userRepository.save(userInfo);
        return userInfo;
    }


    /**
     * 10000 of records
     *  --> (0,20) (21,40)
     *
     *     limit 20
     *     limit 21 40
     *
     * @return
     */
    public List<UserInfo> fetchAllUsers(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 20);
        return userRepository.findAll(pageable).getContent();
    }

    public Optional<UserInfo> fetchOneById(Integer id) {
        return userRepository.findById(id);
    }



}
