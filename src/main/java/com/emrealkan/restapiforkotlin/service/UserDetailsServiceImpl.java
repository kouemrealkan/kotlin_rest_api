package com.emrealkan.restapiforkotlin.service;
import com.emrealkan.restapiforkotlin.model.User;
import com.emrealkan.restapiforkotlin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> userOptional = userRepository.findByUserName(userName);
        User user = userOptional.orElseThrow(()-> new UsernameNotFoundException("No User Found "+userName));
        return new org.springframework.security
                .core.userdetails.User(user.getUserName(),
                user.getPassword(),
                getAuthorities());

    }
    private Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
