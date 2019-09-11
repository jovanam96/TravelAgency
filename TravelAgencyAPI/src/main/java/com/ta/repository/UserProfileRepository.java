/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.repository;

import com.ta.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jovana Mitrovic
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    UserProfile findByUsername(String username);

    UserProfile findByPersonEmail(String email);
}
