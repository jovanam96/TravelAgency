

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service;

import com.ta.controller.dto.OfferDTO;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Jovana Mitrovic
 */
public interface OfferService {

    public List<OfferDTO> findAll();

    public OfferDTO findById(int id) throws EntityNotFoundException;

    public OfferDTO saveOrUpdateOffer(OfferDTO offer);

    public void deleteOffer(int id);
    
   // public List<Offer> search(int cityId, Date dateFrom, Date dateTo);

    public List<OfferDTO> findByHotel(int hotelId);
    
}
