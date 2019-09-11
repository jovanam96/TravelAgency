/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.controller.dto.OfferDTO;
import com.ta.entity.Offer;
import com.ta.entity.OfferItem;
import com.ta.repository.OfferItemRepository;
import com.ta.repository.OfferRepository;
import com.ta.service.OfferService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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
public class OfferServiceImpl implements OfferService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private OfferItemRepository offerItemRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OfferDTO> findAll() {
        List<Offer> offers =  offerRepository.findAll();
        return offers.stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OfferDTO findById(int id) throws EntityNotFoundException{
        Optional<Offer> optional = offerRepository.findById(id);

        if (optional.isPresent()) {
            return modelMapper.map(optional.get(), OfferDTO.class);
        }
        throw new EntityNotFoundException("Offer with id " + id + " does not exist!");
    }

    @Override
    public OfferDTO saveOrUpdateOffer(OfferDTO dto) {
        Offer offer = modelMapper.map(dto, Offer.class);
        Offer savedOffer = offerRepository.save(offer);
        for (OfferItem item : offer.getItems()) {
            item.setOffer(new Offer(savedOffer.getOfferId(), null, null, null, null, null));
            // item.setOffer(savedOffer);
            // offerItemRepository.deleteOfferItemByOfferOfferId(savedOffer.getOfferId());
        }
        
        offerItemRepository.saveAll(offer.getItems());
        return modelMapper.map(savedOffer, OfferDTO.class);
    }

    @Override
    public void deleteOffer(int id) {
        offerRepository.deleteById(id);
    }

//    @Override
//    public List<Offer> search(int cityId, Date dateFrom, Date dateTo) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery cq = cb.createQuery();
//        Root<Offer> offerRoot = cq.from(Offer.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//
//        if (cityId != 0) {
//            predicates.add(cb.equal(offerRoot.get("city").get("cityId"), cityId));
//        }
//
//        if (dateFrom != null) {
//            predicates.add(cb.lessThanOrEqualTo(offerRoot.<Date>get("dateFrom"), dateFrom));
//            if (dateTo != null) {
//                 predicates.add(cb.greaterThanOrEqualTo(offerRoot.<Date>get("dateTo"), dateTo));
//            } else {
//                predicates.add(cb.greaterThanOrEqualTo(offerRoot.<Date>get("dateTo"), dateFrom));
//            }
//        }
//
//        cq.select(offerRoot).where(predicates.toArray(new Predicate[]{}));
//        return entityManager.createQuery(cq).getResultList();
//    }

    @Override
    public List<OfferDTO> findByHotel(int hotelId) {
        List<Offer> offers = offerRepository.findByHotelHotelId(hotelId);
        return offers.stream()
                .map(offer -> modelMapper.map(offer, OfferDTO.class))
                .collect(Collectors.toList());
    }
}
