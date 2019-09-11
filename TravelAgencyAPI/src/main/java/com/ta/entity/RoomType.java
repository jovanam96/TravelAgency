/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Jovana Mitrovic
 */

@Entity
public class RoomType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rooomTypeId;
    private String name;

    public RoomType() {
    }

    public RoomType(int rooomTypeId, String name) {
        this.rooomTypeId = rooomTypeId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRooomTypeId() {
        return rooomTypeId;
    }

    public void setRooomTypeId(int rooomTypeId) {
        this.rooomTypeId = rooomTypeId;
    }
    
    
}
