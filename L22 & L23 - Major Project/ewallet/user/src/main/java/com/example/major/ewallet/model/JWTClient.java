package com.example.major.ewallet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class JWTClient implements UserDetails {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private S2SClient client;


    /**
     * demoRoles
     * BOOK - BOOK:PAYMENT:CART
     * CART -
     */
    @Column(nullable = false)
    private String demoRoles;

    /**
     * Dirty logic --> here are the roles present
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] split = demoRoles.split(":");
        return Arrays.stream(split).map(inp -> new SimpleGrantedAuthority("ROLE_" + inp)).collect(Collectors.toList());

//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + client.name()));
    }

    @Override
    public String getPassword() {
        return client.name();
    }

    @Override
    public String getUsername() {
        return client.name();
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
}
