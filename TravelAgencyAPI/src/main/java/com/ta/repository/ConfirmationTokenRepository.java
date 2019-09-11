/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.repository;

import com.ta.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jovana Mitrovic
 */
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {

    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
