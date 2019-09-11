/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.controller.dto.RoomTypeDTO;
import com.ta.entity.RoomType;
import com.ta.repository.RoomTypeRepository;
import com.ta.service.RoomTypeService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
public class RoomTypeServiceImpl implements RoomTypeService {
    
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RoomTypeDTO> findAll() {
        List<RoomType> roomTypes = roomTypeRepository.findAllByOrderByName();
        return roomTypes.stream()
                .map(roomType -> modelMapper.map(roomType, RoomTypeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoomTypeDTO findById(int id) {
        Optional<RoomType> optional = roomTypeRepository.findById(id);
        
        if(optional.isPresent()) {
            return modelMapper.map(optional.get(), RoomTypeDTO.class);
        }
        return null;
    }
    
}
