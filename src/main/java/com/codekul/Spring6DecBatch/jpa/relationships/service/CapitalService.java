package com.codekul.Spring6DecBatch.jpa.relationships.service;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Capital;

import java.util.List;
import java.util.Map;

public interface CapitalService {
    Map<String,Object> saveCapital(Capital capital);

    Map<String,Object> findAll();

    Map<String,Object> getCapitalByCountryId(Long countryId);
}
