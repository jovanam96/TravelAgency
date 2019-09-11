/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.controller.dto.ReservationDTO;
import com.ta.entity.OfferItem;
import com.ta.entity.Reservation;
import com.ta.repository.OfferItemRepository;
import com.ta.repository.ReservationRepository;
import com.ta.service.ReservationService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jovana Mitrovic
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private OfferItemRepository offerItemRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReservationDTO> findByClient(int personId) {
        List<Reservation> reservations = reservationRepository.findByClientPersonId(personId);
        return reservations.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<ReservationDTO> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO findById(int id) throws EntityNotFoundException {
        Optional<Reservation> optional = reservationRepository.findById(id);

        if (optional.isPresent()) {
            return modelMapper.map(optional.get(), ReservationDTO.class);
        }
        throw new EntityNotFoundException("Reservation with id " + id + " does not exist");
    }

    @Override
    public void deleteReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public ReservationDTO saveReservation(ReservationDTO dto) {
        Reservation reservation = modelMapper.map(dto, Reservation.class);
        OfferItem offerItem = reservation.getOfferItem();
        offerItem.setCapacity(offerItem.getCapacity()-1);
        offerItemRepository.save(offerItem);
        return modelMapper.map(reservationRepository.save(reservation), ReservationDTO.class);
    }

}
