/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ta.entity.OfferItemId;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jovana Mitrovic
 */
public class OfferItemDTO implements Serializable{
    
    private OfferItemId offerItemId;
    private BigDecimal price;
    private int capacity;
    @NotNull(message = "Room type is required")
    private RoomTypeDTO roomType;
    @JsonIgnore
    private OfferDTO offer;


    public OfferItemDTO() {
    }

    public OfferItemDTO(OfferItemId offerItemId, BigDecimal price, int capacity, RoomTypeDTO roomType, OfferDTO offer) {
        this.offerItemId = offerItemId;
        this.price = price;
        this.capacity = capacity;
        this.roomType = roomType;
        this.offer = offer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public RoomTypeDTO getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeDTO roomType) {
        this.roomType = roomType;
    }

    public OfferDTO getOffer() {
        return offer;
    }

    public void setOffer(OfferDTO offer) {
        this.offer = offer;
    }

    public OfferItemId getOfferItemId() {
        return offerItemId;
    }

    public void setOfferItemId(OfferItemId offerItemId) {
        this.offerItemId = offerItemId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    
}
