/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.service.impl;

import com.ta.entity.OfferItem;
import com.ta.repository.OfferItemRepository;
import com.ta.service.OfferItemService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jovana Mitrovic
 */

@Service
@Transactional
public class OfferItemServiceImpl implements OfferItemService{
    
    @Autowired
    private OfferItemRepository offerItemRepository;

    @Override
    public void saveOrUpdateOfferItem(List<OfferItem> items) {
        offerItemRepository.saveAll(items);
    }
    
}
