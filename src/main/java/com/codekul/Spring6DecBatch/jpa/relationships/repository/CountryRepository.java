package com.codekul.Spring6DecBatch.jpa.relationships.repository;

import com.codekul.Spring6DecBatch.jpa.relationships.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    Country findByCountryName(String countryName);

    Country findByCountryCode(String countryCode);

    Boolean existsByCountryCode(String countryCode);

    Boolean existsByCountryName(String countryName);

    Country findByCountryCodeAndCountryName(String countryCode,String countryName);

    List<Country> findByCountryNameLike(String countryName);
}
