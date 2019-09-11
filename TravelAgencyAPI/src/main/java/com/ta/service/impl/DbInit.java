/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.entity.Client;
import com.ta.entity.Employee;
import com.ta.entity.Person;
import com.ta.entity.UserProfile;
import com.ta.repository.UserProfileRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jovana Mitrovic
 */

@Service
public class DbInit implements CommandLineRunner  {
    
    @Autowired
    private UserProfileRepository userProfileRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
       // userProfileRepository.deleteAll();
        
//        List<UserProfile> users = new ArrayList<>();
//        
//        Person client = new Client();
//        client.setPersonId(1);
//        
//        Person admin = new Employee();
//        admin.setPersonId(2);
//        
//        users.add(new UserProfile(0, "client", passwordEncoder.encode("client"), 1, "CLIENT", client));
//        users.add(new UserProfile(0, "admin", passwordEncoder.encode("admin"), 1, "ADMIN", admin));
//        
//        userProfileRepository.saveAll(users);
                
    }
    
}
