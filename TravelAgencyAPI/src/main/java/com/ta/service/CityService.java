/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service;

import com.ta.controller.dto.CityDTO;
import java.util.List;

/**
 *
 * @author Jovana Mitrovic
 */
public interface CityService {

    public List<CityDTO> findAll();
}
