/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller;

import com.ta.controller.dto.UserProfileDTO;
import com.ta.entity.Client;
import com.ta.entity.UserProfile;
import com.ta.repository.ClientRepository;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ta.service.UserProfileService;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Jovana Mitrovic
 */

@RestController
@RequestMapping("/userProfile")
@CrossOrigin
public class UserProfileController {
    
    @Autowired
    private UserProfileService userProfileService;
    
    @PostMapping("/register")
    public void register(@Valid @RequestBody UserProfileDTO dto) throws SQLIntegrityConstraintViolationException {
        userProfileService.sendEmail(dto);
    }
    
    @GetMapping("/confirm-account")
    public UserProfile confirmAccount(@RequestParam("token") String token) {
        return userProfileService.confirmAccount(token);
    }
    
    @PutMapping("/update")
    public UserProfileDTO updateUserProfile(@RequestBody UserProfileDTO dto) {
        return userProfileService.update(dto);
    }
    
}
