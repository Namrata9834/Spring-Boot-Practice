package com.codekul.Spring6DecBatch.jpa.relationships.service.impl;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Country;
import com.codekul.Spring6DecBatch.jpa.relationships.repository.CountryRepository;
import com.codekul.Spring6DecBatch.jpa.relationships.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.codekul.Spring6DecBatch.util.Constants.MESSAGE;
import static com.codekul.Spring6DecBatch.util.Constants.STATUS;

@Slf4j
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public Map<String,Object> saveCountry(Country country) {
        Map<String,Object> map = new HashMap<>();

        if (countryRepository.existsByCountryCode(country.getCountryCode())){
            map.put(MESSAGE,"Duplicate Country code");
            map.put(STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        else if(countryRepository.existsByCountryName(country.getCountryName())){
            map.put(MESSAGE,"Duplicate Country name");
            map.put(STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        else {
            countryRepository.save(country);
            map.put(MESSAGE, "Country saved successfully");
            map.put(STATUS, HttpStatus.CREATED.value());
        }
        return map;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findByCountryName(String country) {
        return countryRepository.findByCountryName(country);
    }

    @Override
    public Country getByCountryCode(String countryCode) {
        return countryRepository.findByCountryCode(countryCode);
    }

    @Override
    public Country getByCountryCodeAndCountryName(String countryCode, String countryName) {
        return countryRepository.findByCountryCodeAndCountryName(countryCode,countryName);
    }

    @Override
    public Map<String, Object> updateCountry(Long id,String countryName) {
        Map<String,Object> map = new HashMap<>();
        Optional<Country> countryOptional = countryRepository.findById(id);
        if (countryOptional.isPresent()){
            Country country = countryOptional.get();
            country.setCountryName(countryName);
            countryRepository.save(country);
            map.put(MESSAGE,"Country updated successfully");
            map.put(STATUS,HttpStatus.OK.value());
        }else {
            map.put(MESSAGE,"NOT FOUNT");
            map.put(STATUS,HttpStatus.NOT_FOUND.value());
        }

        return map;
    }
}
