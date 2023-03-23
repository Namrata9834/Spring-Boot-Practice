package com.codekul.Spring6DecBatch.jpa.relationships.controller;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Capital;
import com.codekul.Spring6DecBatch.jpa.relationships.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController  // to call the rest apis(get,put.post,delete)
@RequestMapping("/capital")
public class CapitalController {
    @Autowired
    private CapitalService capitalService;
    @PostMapping
    public Map<String,Object> saveCapital(@RequestBody Capital capital){
        return capitalService.saveCapital(capital);
    }

    @GetMapping
    public Map<String,Object> findAll(){
        return capitalService.findAll();
    }


    @GetMapping("/getCapitalByCountryId")
    public Map<String,Object> getCapitalByCountryId(@RequestParam Long countryId){
        return capitalService.getCapitalByCountryId(countryId);
    }
}
