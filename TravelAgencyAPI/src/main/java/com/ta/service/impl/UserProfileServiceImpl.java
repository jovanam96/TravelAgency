/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.controller.dto.UserProfileDTO;
import com.ta.entity.Client;
import com.ta.entity.ConfirmationToken;
import com.ta.entity.UserProfile;
import com.ta.repository.ClientRepository;
import com.ta.repository.ConfirmationTokenRepository;
import com.ta.repository.UserProfileRepository;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ta.service.UserProfileService;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Jovana Mitrovic
 */
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void sendEmail(UserProfileDTO dto) throws SQLIntegrityConstraintViolationException {
        Client client = modelMapper.map(dto.getPerson(), Client.class);
        UserProfile userProfile = new UserProfile();
        userProfile.setPerson(clientRepository.save(client));
        userProfile.setUsername(dto.getUsername());
        userProfile.setPassword(dto.getPassword());

        UserProfile existingUserProfile = userProfileRepository.findByUsername(userProfile.getUsername());
        if (existingUserProfile != null) {
            throw new SQLIntegrityConstraintViolationException("Username is already taken!");
        } else {
            userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
            userProfileRepository.save(userProfile);
            ConfirmationToken confirmationToken = new ConfirmationToken(userProfile);
            confirmationTokenRepository.save(confirmationToken);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(userProfile.getPerson().getEmail());
            simpleMailMessage.setFrom("jovana_996@yahoo.com");
            simpleMailMessage.setSubject("Confirmation email");
            simpleMailMessage.setText("Welcome " + userProfile.getPerson().getEmail() + "\n" + "Thank you for registering!\nPlease verify your email by clicking on this link: "
                    + "http://localhost:4200/login?token=" + confirmationToken.getConfirmationToken());
            javaMailSender.send(simpleMailMessage);
        }
    }

    @Override
    public UserProfile confirmAccount(String token) {
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByConfirmationToken(token);
        if (confirmationToken != null) {
            Optional<UserProfile> optional = userProfileRepository.findById(confirmationToken.getUserProfile().getUserProfileId());
            if (optional.isPresent()) {
                UserProfile userProfile = optional.get();
                userProfile.setActive(1);
                userProfile.setRoles("CLIENT");
                //  passwordEncoder.encode(userProfile.getPassword());
                return userProfileRepository.save(userProfile);
            }
        }
        return null;
    }

    @Override
    public UserProfileDTO update(UserProfileDTO dto) {
        Client client = modelMapper.map(dto.getPerson(), Client.class);
        UserProfile userProfile = new UserProfile();
        userProfile.setPerson(clientRepository.save(client));
        return modelMapper.map(userProfile, UserProfileDTO.class);
    }

}
