/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.repository;

import com.ta.entity.Offer;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jovana Mitrovic
 */

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    
  @Query("select o from Offer o " +
         "where o.dateFrom between ?1 and ?2 and o.dateTo between ?1 and ?2")
  List<Offer> findByDatesBetween(Date dateFrom, Date dateTo);
  
  List<Offer> findByHotelHotelId(int hotelId);
    
}
