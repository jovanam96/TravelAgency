/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ta.controller.dto.HotelDTO;
import com.ta.entity.Hotel;
import com.ta.service.HotelService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jovana Mitrovic
 */
@RestController
@RequestMapping("/hotel")
@CrossOrigin
public class HotelController {
    
    @Autowired
    private HotelService hotelService;
    
    
    
    @Autowired
    private ServletContext servletContext;
    
    @GetMapping("/all")
    public List<HotelDTO> findAll() {
        return hotelService.findAll();
    }
    
    @GetMapping("/{id}")
    public HotelDTO findById(@PathVariable int id) {
        HotelDTO dto = hotelService.findById(id);
        attachFile(dto);
        return dto;
    }
    
    @GetMapping("/search")
    public List<HotelDTO> search(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cityId", required = false, defaultValue = "0") int cityId) {
        
        List<HotelDTO> dtos = hotelService.search(name, cityId);
        
        for (HotelDTO dto : dtos) {
            attachFile(dto);
        }
        return dtos;
    }
    
    @GetMapping("/city/{cityId}")
    public List<HotelDTO> findByCity(@PathVariable int cityId) {
        return hotelService.findByCity(cityId);
    }
    
    @RequestMapping(value = {"/new", "/update"}, method = {RequestMethod.POST, RequestMethod.PUT})
    public HotelDTO saveOrUpdateHotel(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam("hotel") String hotelJson)
            throws IOException, MaxUploadSizeExceededException {
        HotelDTO dto = new ObjectMapper().readValue(hotelJson, HotelDTO.class);
        boolean isExists = new File(servletContext.getRealPath("/images/hotel/")).exists();
        if (!isExists) {
            new File(servletContext.getRealPath("/images/hotel/")).mkdir();
        }
        if (file != null) {
            if (!(new File(servletContext.getRealPath("/images/hotel/" + dto.getFileName()))).exists()) {
                String fileName = FilenameUtils.getBaseName(file.getOriginalFilename()) + "_" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
                File serverFile = new File(servletContext.getRealPath(("/images/hotel/")) + File.separator + fileName);
                try {
                    FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
                } catch (IOException ex) {
                    Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
                }
                dto.setFileName(fileName);
            }
        } else {
            dto.setFileName("default-image.png");
        }
        
        return hotelService.saveOrUpdateHotel(dto);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteHotel(@PathVariable int id) {
        hotelService.deleteHotel(id);
    }
    
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
