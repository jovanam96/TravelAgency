/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller;

import com.ta.controller.dto.ReservationDTO;
import com.ta.entity.Reservation;
import com.ta.service.ReservationService;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jovana Mitrovic
 */
@RestController
@RequestMapping("/reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    
    @GetMapping("/all")
    public List<ReservationDTO> findAll() {
        return reservationService.findAll();
    }
    
    @GetMapping("/all/{id}")
    public ReservationDTO findById(@PathVariable int id) throws EntityNotFoundException {
        return reservationService.findById(id);
    }

    
    @PostMapping("/new")
    public ReservationDTO saveReservation(@Valid @RequestBody ReservationDTO dto) {
        return reservationService.saveReservation(dto);
    }
    
    @GetMapping("/all/client/{personId}")
    public List<ReservationDTO> findByClient(@PathVariable int personId) {
        return reservationService.findByClient(personId);
    }
    
    @DeleteMapping("/all/{reservationId}")
    public void deleteReservatioin(@PathVariable int reservationId){
        reservationService.deleteReservation(reservationId);
    }
}
