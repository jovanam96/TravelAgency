/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service;

import com.ta.controller.dto.UserProfileDTO;
import com.ta.entity.UserProfile;
import java.sql.SQLIntegrityConstraintViolationException;


/**
 *
 * @author Jovana Mitrovic
 */
public interface UserProfileService {
    
    public void sendEmail(UserProfileDTO dto) throws SQLIntegrityConstraintViolationException;

    public UserProfile confirmAccount(String token);

    public UserProfileDTO update(UserProfileDTO dto);
}
