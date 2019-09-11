/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.security;

import com.ta.entity.UserProfile;
import com.ta.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jovana Mitrovic
 */

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        UserProfile userProfile = userProfileRepository.findByUsername(string);
        return new UserPrincipal(userProfile);
    }
    
}
