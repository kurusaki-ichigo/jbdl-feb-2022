package com.example.cache.cache.service;

import com.example.cache.cache.dao.UserDao;
import com.example.cache.cache.entities.UserInfo;
import com.example.cache.cache.request.CreateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements InitializingBean {

    @Autowired
    UserDao dao;

    public Optional<UserInfo> loadUserByUsername(String username) {
        return dao.findByEmail(username);
    }

    public UserInfo createUser(CreateUserRequestDto userRequestDto) {
        UserInfo userInfo = userRequestDto.toUser();
        userInfo.setPassword(userInfo.getPassword());
        dao.save(userInfo);
        return userInfo;
    }


    /**
     * 10000 of records
     * --> (0,20) (21,40)
     * <p>
     * limit 20
     * limit 21 40
     *
     * @return
     */
    public List<UserInfo> fetchAllUsers(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 20);
        return dao.findAll(pageable).getContent();
    }

    public Optional<UserInfo> fetchOneById(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
