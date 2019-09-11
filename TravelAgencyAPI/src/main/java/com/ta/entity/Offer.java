/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jovana Mitrovic
 */

@Entity
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offerId;
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Hotel hotel;
    @ManyToOne(cascade = CascadeType.MERGE)
    private City city;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    private List<OfferItem> items;

    public Offer() {
    }

    public Offer(int offerId, Date dateFrom, Date dateTo, Hotel hotel, City city, List<OfferItem> items) {
        this.offerId = offerId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.hotel = hotel;
        this.city = city;
        this.items = items;
    }

    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public List<OfferItem> getItems() {
        return items;
    }

    public void setItems(List<OfferItem> items) {
        this.items = items;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
