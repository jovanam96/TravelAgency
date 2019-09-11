/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jovana Mitrovic
 */

@Entity
@DiscriminatorValue(value = "employee")
public class Employee extends Person implements Serializable {
    private int workBookNumber;
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    public Employee() {
    }

    public Employee(int workBookNumber, Date hireDate, int personId, String jmbg, String firstName, String lastName, String email) {
        super(personId, jmbg, firstName, lastName, email);
        this.workBookNumber = workBookNumber;
        this.hireDate = hireDate;
    }


    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getWorkBookNumber() {
        return workBookNumber;
    }

    public void setWorkBookNumber(int workBookNumber) {
        this.workBookNumber = workBookNumber;
    }
    
    
}
