package com.delfix.escuela.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{

    
    @Override
    public String findByUsername(String name) {
        return "Fidelmar";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        List<GrantedAuthority> authorities =  Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User("admin", "$2a$10$XDdIkqp.9TT4TqqFzjp2weY7RbRs4OyLCmH.qNLvfIw9gveJq15OW",
         true, true, true, true, authorities);
    }
    
    
}
