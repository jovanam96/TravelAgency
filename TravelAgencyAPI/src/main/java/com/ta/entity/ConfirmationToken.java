/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jovana Mitrovic
 */
@Entity
public class ConfirmationToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tokenId;
    private String confirmationToken;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @OneToOne(targetEntity = UserProfile.class, fetch = FetchType.EAGER)
    @JoinColumn
    private UserProfile userProfile;

    public ConfirmationToken() {
    }

    public ConfirmationToken(UserProfile userProfile) {
        this.userProfile = userProfile;
        this.creationDate = new Date();
        this.confirmationToken = UUID.randomUUID().toString();
    }

    public ConfirmationToken(int tokenId, String confirmationToken, Date creationDate, UserProfile userProfile) {
        this.tokenId = tokenId;
        this.confirmationToken = confirmationToken;
        this.creationDate = creationDate;
        this.userProfile = userProfile;
    }

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    
    
}
