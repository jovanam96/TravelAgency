/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service;

import com.ta.controller.dto.HotelDTO;
import java.util.List;

/**
 *
 * @author Jovana Mitrovic
 */
public interface HotelService {

    public List<HotelDTO> findAll();

    public HotelDTO findById(int id);

    public List<HotelDTO> findByCity(int cityId);

    public HotelDTO saveOrUpdateHotel(HotelDTO hotel);

    public void deleteHotel(int id);

    public List<HotelDTO> search(String name, int cityId);
}
