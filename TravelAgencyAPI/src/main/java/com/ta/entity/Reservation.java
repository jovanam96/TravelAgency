/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jovana Mitrovic
 */

@Entity
public class Reservation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @ManyToOne
    @JoinColumn
    private Client client;
    @ManyToOne
    private OfferItem offerItem;

    public Reservation() {
    }

    public Reservation(int reservationId, Date creationDate, Client client, OfferItem offerItem) {
        this.reservationId = reservationId;
        this.creationDate = creationDate;
        this.client = client;
        this.offerItem = offerItem;
    }


    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OfferItem getOfferItem() {
        return offerItem;
    }

    public void setOfferItem(OfferItem offerItem) {
        this.offerItem = offerItem;
    }
    
    @PrePersist
    protected void prePersist() {
        if (creationDate == null) {
            creationDate = new Date();
        }
    }

    public int getReservationId() {
        return reservationId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    
}
