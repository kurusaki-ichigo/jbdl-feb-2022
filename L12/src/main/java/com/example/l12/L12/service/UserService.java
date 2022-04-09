package com.example.l12.L12.service;

import com.example.l12.L12.models.UserInfo;
import com.example.l12.L12.repository.UserRepository;
import com.example.l12.L12.requests.CreateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
