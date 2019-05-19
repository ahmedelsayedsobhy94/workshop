/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.workshop.repositry;

import com.demo.workshop.model.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ahmed.Elsayed
 */
public interface repos extends CrudRepository<City, Long>{
  List<City> findByName(String name);  
}
