package com.codekul.Spring6DecBatch.jpa.relationships.controller;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Country;
import com.codekul.Spring6DecBatch.jpa.relationships.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public Map<String, Object> saveCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }

    @GetMapping("/findByCountryName/{country}")
    public Country findByCountryName(@PathVariable String country){
        return countryService.findByCountryName(country);
    }

    @GetMapping("/findByCountryCode/{countryCode}")
    public Country findByCountryCode(@PathVariable String countryCode){
        return countryService.getByCountryCode(countryCode);
    }

    @GetMapping("/findByCountryCodeAndName/{countryCode}/{countryName}")
    public Country findByCountryCodeAndName(@PathVariable String countryCode,
                                     @PathVariable String countryName){
        return countryService.getByCountryCodeAndCountryName(countryCode,countryName);
    }

    @PutMapping("/updateCountry/{id}")
    public Map<String,Object> updateCountry(@PathVariable Long id,
            @RequestParam String countryName){
        return  countryService.updateCountry(id,countryName);
    }

}
