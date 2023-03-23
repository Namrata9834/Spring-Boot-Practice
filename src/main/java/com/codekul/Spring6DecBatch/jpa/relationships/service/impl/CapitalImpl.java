package com.codekul.Spring6DecBatch.jpa.relationships.service.impl;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Capital;
import com.codekul.Spring6DecBatch.jpa.relationships.repository.CapitalRepository;
import com.codekul.Spring6DecBatch.jpa.relationships.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codekul.Spring6DecBatch.util.Constants.*;

@Service
public class CapitalImpl implements CapitalService {
    @Autowired
    private CapitalRepository capitalRepository;
    @Override
    public Map<String, Object> saveCapital(Capital capital) {
        Map<String,Object> map = new HashMap<>();
        map.put(MESSAGE,"Capital Saved Successfully");
        map.put(STATUS, HttpStatus.CREATED.value());
        capitalRepository.save(capital);
        return map;
    }

    @Override
    public Map<String,Object> findAll() {
        Map<String,Object> map = new HashMap<>();
        map.put(MESSAGE,"Get All ");
        map.put(STATUS, HttpStatus.CREATED.value());
        map.put(RESULT,capitalRepository.getAllCapitalWithCountryCodeAndName());
        return map;
    }

    @Override
    public Map<String, Object> getCapitalByCountryId(Long countryId) {
        Map<String,Object> map = new HashMap<>();
        map.put(MESSAGE,"Get All ");
        map.put(STATUS, HttpStatus.CREATED.value());
        map.put(RESULT,capitalRepository.getCapitalByCountryId(countryId));
        return map;
    }
}
