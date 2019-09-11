/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.controller.dto.HotelDTO;
import com.ta.entity.Hotel;
import com.ta.repository.HotelRepository;
import com.ta.service.HotelService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class HotelServiceImpl implements HotelService {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private HotelRepository hotelRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<HotelDTO> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDTO findById(int id) {
        Optional<Hotel> optional = hotelRepository.findById(id);

        if (optional.isPresent()) {
            return modelMapper.map(optional.get(), HotelDTO.class);
        }

        throw new EntityNotFoundException("Hotes with " + id + " does not exist!");

    }


    @Override
    public List<HotelDTO> findByCity(int cityId) {
        List<Hotel> hotels =  hotelRepository.findByCityCityId(cityId);
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HotelDTO saveOrUpdateHotel(HotelDTO dto) {
        Hotel hotel = modelMapper.map(dto, Hotel.class);
        return modelMapper.map(hotelRepository.save(hotel), HotelDTO.class);
    }


    @Override
    public void deleteHotel(int id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelDTO> search(String name, int cityId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Hotel> hotelRoot = cq.from(Hotel.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        if(name != null) {
            predicates.add(cb.like(hotelRoot.get("name"), name+"%"));
        }

        if(cityId != 0) {
            predicates.add(cb.equal(hotelRoot.get("city").get("cityId"), cityId));
        }
        
        cq.select(hotelRoot).where(predicates.toArray(new Predicate[]{}));
        List<Hotel> hotels =  entityManager.createQuery(cq).getResultList();
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                .collect(Collectors.toList());
    }

    
    
    
    

}
