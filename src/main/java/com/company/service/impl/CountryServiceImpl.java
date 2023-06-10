/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.service.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author FX506ICB
 */
@Repository
@Transactional
public class CountryServiceImpl extends AbstractDAO implements CountryServiceInter {
    @Autowired
    CountryDaoInter countryDaoInter;

    @Override
    public List<Country> getAllCountry() {
        return countryDaoInter.getAllCountry();
    }

    @Override
    public Country getCountryByName(String name) {
        return countryDaoInter.getCountryByName(name);
    }

    @Override
    public boolean updateCountry(Country cc) {
        return countryDaoInter.updateCountry(cc);
    }

    @Override
    public boolean removeCountry(int id) {
        return countryDaoInter.removeCountry(id);
    }

    @Override
    public boolean addCountry(Country cc) {
        return countryDaoInter.addCountry(cc);
    }

}
  