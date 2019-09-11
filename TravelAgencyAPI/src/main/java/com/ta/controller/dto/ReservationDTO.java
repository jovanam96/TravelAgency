/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jovana Mitrovic
 */
public class ReservationDTO implements Serializable{
    
    private int reservationId;
    private Date creationDate;
    private Date checkIn;
    private Date checkOut;
    private BigDecimal totalPrice;
    private ClientDTO client;
    private OfferItemDTO offerItem;

    public ReservationDTO() {
    }

    public ReservationDTO(int reservationId, Date creationDate, Date checkIn, Date checkOut, BigDecimal totalPrice, ClientDTO client, OfferItemDTO offerItem) {
        this.reservationId = reservationId;
        this.creationDate = creationDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.client = client;
        this.offerItem = offerItem;
    }

    public OfferItemDTO getOfferItem() {
        return offerItem;
    }

    public void setOfferItem(OfferItemDTO offerItem) {
        this.offerItem = offerItem;
    }

    

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
    
    
    
    
}
