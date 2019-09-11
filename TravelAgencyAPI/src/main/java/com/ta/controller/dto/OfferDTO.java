/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jovana Mitrovic
 */
public class OfferDTO implements Serializable{
    
    private int offerId;
    private Date dateFrom;
    private Date dateTo;
    @NotNull(message = "Hotel is required")
    private HotelDTO hotel;
    @NotNull(message = "City is required")
    private CityDTO city;
    private @Valid List<OfferItemDTO> items;
    
    public OfferDTO() {
    }

    public OfferDTO(int offerId, Date dateFrom, Date dateTo, HotelDTO hotel, CityDTO city, List<OfferItemDTO> items) {
        this.offerId = offerId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.hotel = hotel;
        this.city = city;
        this.items = items;
    }

    

    public HotelDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerid) {
        this.offerId = offerid;
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

    public List<OfferItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OfferItemDTO> items) {
        this.items = items;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
    
    
    
}
