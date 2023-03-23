package com.codekul.Spring6DecBatch.jpa.relationships.service;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Country;

import java.util.List;
import java.util.Map;

public interface CountryService {
    Map<String,Object> saveCountry(Country country);

    List<Country> findAll();

    Country findByCountryName(String country);

    Country getByCountryCode(String countryCode);

    Country getByCountryCodeAndCountryName(String countryCode,String countryName);
    //void findAll();

    Map<String,Object> updateCountry(Long id,String countryName);
}
