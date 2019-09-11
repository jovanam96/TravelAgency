/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service;

import com.ta.controller.dto.ReservationDTO;
import com.ta.entity.Reservation;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author Jovana Mitrovic
 */
public interface ReservationService {

    public List<ReservationDTO> findByClient(int personId);

    public List<ReservationDTO> findAll();

    public ReservationDTO findById(int id) throws EntityNotFoundException;

    public void deleteReservation(int reservationId);

    public ReservationDTO saveReservation(ReservationDTO reservation);
}
