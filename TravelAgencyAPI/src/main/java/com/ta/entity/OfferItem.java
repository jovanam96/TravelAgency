/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author Jovana Mitrovic
 */
@Entity
public class OfferItem implements Serializable{
    
    @EmbeddedId
    private OfferItemId offerItemId;
    private BigDecimal price;
    @ManyToOne
    private RoomType roomType;
    private int capacity;
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("offerId")
    @JoinColumn
    private Offer offer;


    public OfferItem() {
    }

    public OfferItem(OfferItemId offerItemId, BigDecimal price, RoomType roomType, int capacity, Offer offer) {
        this.offerItemId = offerItemId;
        this.price = price;
        this.roomType = roomType;
        this.capacity = capacity;
        this.offer = offer;
    }


    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
