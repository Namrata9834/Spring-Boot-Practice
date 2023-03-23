package com.codekul.Spring6DecBatch.jpa.relationships.repository;

import com.codekul.Spring6DecBatch.jpa.relationships.dto.response.CapitalResponseDto;
import com.codekul.Spring6DecBatch.jpa.relationships.entity.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CapitalRepository extends JpaRepository<Capital,Long> {

    @Query(value = "select t.id,t.capital,c.country_code,c.country_name from country c inner join capital t on c.id = t.country_id",nativeQuery = true)
    //List<CapitalResponseDto> getAllCapitalWithCountryCodeAndName();
    List<Map<String,Object>> getAllCapitalWithCountryCodeAndName();

    @Query(value = "select t.id,t.capital,c.country_code,c.country_name from country c inner join capital t on c.id = t.country_id where c.id = ?1",nativeQuery = true)
    List<Map<String,Object>> getCapitalByCountryId(Long countryId);
}
