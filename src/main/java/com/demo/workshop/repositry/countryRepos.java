/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.workshop.repositry;

import com.demo.workshop.model.Country;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ahmed.Elsayed
 */
public interface countryRepos extends CrudRepository<Country, Long>{
    
    Country findByCode(String code);
    
}
