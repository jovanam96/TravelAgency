/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller.dto;

import java.io.Serializable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jovana Mitrovic
 */
public class ClientDTO implements Serializable{
    
    private int personId;
    @NotBlank(message = "Jmbg is required")
    @Size(min = 13, max = 13, message = "Jmbg must contain 13 digits")
    @Pattern(regexp = "[0-9]*", message = "Jmbg must contain only digits")
    private String jmbg;
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "[a-zA-Z]*", message = "First name must contain only letters")
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "[a-zA-Z]*", message = "Last name must contain only letters")
    private String lastName;
    @NotBlank(message = "Email is required")
    @Email(message = "Not a valid email")
    private String email;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "[0-9]*", message = "Phone number must contain only digits")
    private String phoneNumber;

    public ClientDTO() {
    }

    public ClientDTO(int personId, String jmbg, String firstName, String lastName, String email, String phoneNumber) {
        this.personId = personId;
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    
}
