/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Jovana Mitrovic
 */

public class HotelDTO implements Serializable{
    
    private int hotelId;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Adress is required")
    private String adress;
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "+[0-9]*", message = "Phone number must start with + and contain only digits")
    private String phoneNumber;
    @NotBlank(message = "Email is required")
    @Email(message = "Not a valid email")
    private String email;
    @NotBlank(message = "Descriiption is required")
    private String description;
    @NotNull(message = "City is required")
    private CityDTO city;
    private String fileName;
    private String image;

    public HotelDTO() {
    }

    public HotelDTO(int hotelId, String name, String adress, String phoneNumber, String email, String description, CityDTO city, String fileName, String image) {
        this.hotelId = hotelId;
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.city = city;
        this.fileName = fileName;
        this.image = image;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
}
