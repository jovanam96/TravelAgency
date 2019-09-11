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
public class StateDTO implements Serializable{
    private int stateId;
    private String name;

    public StateDTO() {
    }

    public StateDTO(int stateId, String name) {
        this.stateId = stateId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
    
    
}
