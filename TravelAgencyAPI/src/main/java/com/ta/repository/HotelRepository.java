/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.repository;

import com.ta.entity.Hotel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jovana Mitrovic
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findByName(String name);

    List<Hotel> findByCityCityId(int cityId);

   // List<Hotel> findByNameAndCityCityId(String name, int cityId);

}
