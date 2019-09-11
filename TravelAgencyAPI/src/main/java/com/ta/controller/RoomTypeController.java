/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller;

import com.ta.controller.dto.RoomTypeDTO;
import com.ta.service.RoomTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jovana Mitrovic
 */

@RestController
@RequestMapping("/roomType")
@CrossOrigin
public class RoomTypeController {
    
    @Autowired
    private RoomTypeService roomTypeService;
    
    
    @GetMapping("/all")
    public List<RoomTypeDTO> findAll() {
        return roomTypeService.findAll();
    }
    
    @GetMapping("/all/{id}")
    public RoomTypeDTO findById(@PathVariable int id) {
        return roomTypeService.findById(id);
    }
    
}
