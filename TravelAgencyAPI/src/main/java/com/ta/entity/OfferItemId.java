/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Jovana Mitrovic
 */
@Embeddable
public class OfferItemId implements Serializable{
    private int offerId;
    private int number;

    public OfferItemId() {
    }

    public OfferItemId(int offerId, int number) {
        this.offerId = offerId;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
    
    
}
