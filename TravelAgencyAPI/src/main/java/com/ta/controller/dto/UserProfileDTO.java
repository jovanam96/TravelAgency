/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jovana Mitrovic
 */
public class UserProfileDTO {
    
    private int userProfileId;
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Username is required")
    private String password;
    private int active;
    @NotNull(message = "Client is required")
    private ClientDTO person;

    public UserProfileDTO() {
    }

    public UserProfileDTO(int userProfileId, String username, String password, int active, ClientDTO person) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.password = password;
        this.active = active;
        this.person = person;
    }

    public int getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public ClientDTO getPerson() {
        return person;
    }

    public void setPerson(ClientDTO person) {
        this.person = person;
    }

    
}
