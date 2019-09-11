/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller.dto;

import java.io.Serializable;

/**
 *
 * @author Jovana Mitrovic
 */
public class CityDTO implements Serializable{
    private int cityId;
    private String name;
    private StateDTO state;

    public CityDTO() {
    }

    public CityDTO(int cityId, String name, StateDTO state) {
        this.cityId = cityId;
        this.name = name;
        this.state = state;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }
    
    
}
