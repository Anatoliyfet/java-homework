package ru.edu.module13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.edu.module13.entity.User;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class CustomUserDetailedService implements UserDetailsService {


    private UserService userService;

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userService.get(username);

       if (user == null) {
           throw new UsernameNotFoundException("User id=" + username + " not found");
       }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority( "ROLE_" + user.getRole()));//

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
