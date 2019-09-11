/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.repository;

import com.ta.entity.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jovana Mitrovic
 */
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    List<Reservation> findByClientPersonId(int id);
    List<Reservation> findByOfferItemOfferOfferId(int id);
}
