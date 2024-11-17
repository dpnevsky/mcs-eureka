package com.pnevsky.mscountry.repository;


import com.pnevsky.mscountry.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByCountryName(String countryName);

//    @Query("SELECT c.countryName from Country c where c.id = :contryId")
//@Param("countryId")

    Optional<Country> findCountryNameById(Long countryId);

}