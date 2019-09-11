/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller;

import com.ta.controller.dto.HotelDTO;
import com.ta.controller.dto.OfferDTO;
import com.ta.service.OfferService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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
@RequestMapping("/offer")
@CrossOrigin
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/all")
    public List<OfferDTO> findAll() {
        List<OfferDTO> dtos = offerService.findAll();
        for (OfferDTO dto : dtos) {
            attachFile(dto.getHotel());
        }
        return dtos;
    }

    @GetMapping("/all/{id}")
    public OfferDTO findById(@PathVariable int id) throws EntityNotFoundException, InvalidDataAccessApiUsageException {
        OfferDTO dto = offerService.findById(id);
        attachFile(dto.getHotel());
        return dto;
    }

    @PostMapping("/new")
    public OfferDTO saveOffer(@Valid @RequestBody OfferDTO dto) {
        return offerService.saveOrUpdateOffer(dto);
    }

    @DeleteMapping("/all/{id}/delete")
    public void deleteOffer(@PathVariable int id) {
        offerService.deleteOffer(id);
    }
    
    @GetMapping("/hotel/{hotelId}")
    public List<OfferDTO> findByHotel(@PathVariable int hotelId) {
        List<OfferDTO> dtos = offerService.findByHotel(hotelId);
        for (OfferDTO dto : dtos) {
            attachFile(dto.getHotel());
        }
        return dtos;
    }

//    @GetMapping("/search")
//    public List<OfferDTO> findByDatesBetween(
//            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId,
//            @RequestParam(value = "dateFrom", required = false) String from,
//            @RequestParam(value = "dateTo", required = false) String to) {
//
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        List<Offer> offers = new ArrayList<>();
//        Date dateFrom = null;
//        Date dateTo = null;
//        try {
//            if (from != null) {
//                dateFrom = sf.parse(from);
//            }
//            if (to != null) {
//                dateTo = sf.parse(to);
//            }
//            offers = offerService.search(cityId, dateFrom, dateTo);
//        } catch (ParseException ex) {
//            Logger.getLogger(OfferController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        List<OfferDTO> dtos = offers.stream()
//                .map(offer -> modelMapper.map(offer, OfferDTO.class))
//                .collect(Collectors.toList());
//        for (OfferDTO dto : dtos) {
//            attachFile(dto.getHotel());
//        }
//        return dtos;
//    }

    private void attachFile(HotelDTO h) {
        File fileFolder = new File(servletContext.getRealPath("images/hotel"));
        if (fileFolder != null) {
            for (final File file : fileFolder.listFiles()) {
                if (!file.isDirectory() && file.getName().equals(h.getFileName())) {
                    String encodeBase64 = null;
                    try {
                        String extension = FilenameUtils.getExtension(file.getName());
                        FileInputStream fis = new FileInputStream(file);
                        byte[] bytes = new byte[(int) file.length()];
                        fis.read(bytes);
                        encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        h.setImage("data:image/" + extension + ";base64," + encodeBase64);
                        fis.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
