/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller;

import com.ta.controller.dto.CityDTO;
import com.ta.entity.City;
import com.ta.service.CityService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jovana Mitrovic
 */

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {
    
    @Autowired
    private CityService cityService;
    
    @GetMapping("/all")
    public List<CityDTO> findAll() {
        return cityService.findAll();
    }
    
}
