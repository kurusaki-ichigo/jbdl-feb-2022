package com.example.L16.L16.service;

import com.example.L16.L16.dao.UserDao;
import com.example.L16.L16.entities.UserInfo;
import com.example.L16.L16.request.CreateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService , InitializingBean {

    @Autowired
    UserDao dao;

    BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> byEmail = dao.findByEmail(username);
        if (byEmail.isEmpty())
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return Collections.singleton(new SimpleGrantedAuthority("ANONYMOUS"));
                }

                @Override
                public String getPassword() {
                    return null;
                }

                @Override
                public String getUsername() {
                    return null;
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            };
        return byEmail.get();
    }

    public UserInfo createUser(CreateUserRequestDto userRequestDto) {
        UserInfo userInfo = userRequestDto.toUser();
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
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
        encoder = new BCryptPasswordEncoder();
    }
}
