/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ta.repository;

import com.ta.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author Jovana Mitrovic
 */
@NoRepositoryBean
public interface PersonRepositoryBase<T extends Person> extends JpaRepository<T, Integer> {
    
}
