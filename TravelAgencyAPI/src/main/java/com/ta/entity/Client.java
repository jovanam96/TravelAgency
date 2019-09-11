 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Jovana Mitrovic
 */

@Entity
@DiscriminatorValue(value = "client")
public class Client extends Person implements Serializable{
    private String phoneNumber;

    public Client() {
    }

    public Client(String phoneNumber, int personId, String jmbg, String firstName, String lastName, String email) {
        super(personId, jmbg, firstName, lastName, email);
        this.phoneNumber = phoneNumber;
    }

    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
