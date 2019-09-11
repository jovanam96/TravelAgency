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


public class RoomTypeDTO implements Serializable{
    
    private int roomTypeId;
    private String name;

    public RoomTypeDTO() {
    }

    public RoomTypeDTO(int roomTypeId, String name) {
        this.roomTypeId = roomTypeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
    
    
}
