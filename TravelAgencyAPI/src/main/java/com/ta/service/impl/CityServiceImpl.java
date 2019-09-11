/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.controller.dto.CityDTO;
import com.ta.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ta.service.CityService;
import com.ta.repository.CityRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Jovana Mitrovic
 */

@Service
@Transactional
public class CityServiceImpl implements CityService{

    @Autowired
    CityRepository cityRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CityDTO> findAll() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(city -> modelMapper.map(city, CityDTO.class))
                .collect(Collectors.toList());
    }
    
}
