/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service;

import com.ta.controller.dto.RoomTypeDTO;
import java.util.List;

/**
 *
 * @author Jovana Mitrovic
 */
public interface RoomTypeService {

    public List<RoomTypeDTO> findAll();

    public RoomTypeDTO findById(int id);
    
}
