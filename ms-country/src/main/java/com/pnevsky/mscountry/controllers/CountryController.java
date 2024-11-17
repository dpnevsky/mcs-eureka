package com.pnevsky.mscountry.controllers;

import com.pnevsky.mscountry.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping("/country-id/{country_name}")
    public Long getCountryId(@PathVariable(value = "country_name") String countryName) {
        return countryRepository.findByCountryName(countryName).get().getId();
    }

    @GetMapping("/country-name/{country_id}")
    public String getCountryName(@PathVariable(value = "country_id") Long countryId) {
        return countryRepository.findCountryNameById(countryId).get().getCountryName();
    }
}
