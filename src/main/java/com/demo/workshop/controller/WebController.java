/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.workshop.controller;

import com.demo.workshop.model.City;
import com.demo.workshop.model.Country;
import com.demo.workshop.model.CountryLanguage;
import com.demo.workshop.repositry.CountryNotFoundException;
import com.demo.workshop.repositry.countryRepos;
import com.demo.workshop.repositry.repos;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmed.Elsayed
 */
@RestController
public class WebController {

    @Autowired
    private repos Repository;
    @Autowired
    private countryRepos RepositoryCoun;

    
    @RequestMapping("/{code}")
    public Country findByCode(@PathVariable String code) {
        Country c = null;
        try{
        c=RepositoryCoun.findByCode(code);
        }catch(Exception e){
        throw new CountryNotFoundException("INTERNAL_ERROR");
        }
       if(c==null){
       throw new CountryNotFoundException("INVALID_COUNTRY_CODE");
       }
       
       else{
        List<CountryLanguage> countLan = new ArrayList<>();
        for (int i = 0; i < c.getCountryLanguageList().size(); i++) {
            if (c.getCountryLanguageList().get(i).getIsOfficial() == true) {
                countLan.add(c.getCountryLanguageList().get(i));
            }
        }
        c.setLanguage(countLan.get(0).getCountryLanguagePK().getLanguage());
       }
        return c;

    }
}
