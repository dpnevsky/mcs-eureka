package com.pnevsky.mscurriculumvitae.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class CountryServiceClient {

    private final RestTemplate restTemplate;

    //    private static final String COUNTRY_SERVICE_URL = "http://localhost:8083/countries";
    private static final String COUNTRY_SERVICE_URL = "http://COUNTRY-SERVICE/countries";

    public Long fetchCountryId(String countryName) {
        Long response = restTemplate.getForObject(COUNTRY_SERVICE_URL + "/country-id/{country_name}", Long.class, countryName);
        if (response != null) {
            return response;
        } else {
            throw new RuntimeException("Failed to fetch country ID for country: " + countryName);
        }
    }

    public String fetchCountryName(Long countryId) {
        String response = restTemplate.getForObject(COUNTRY_SERVICE_URL + "/country-name/{country_id}", String.class, countryId);
        if (response != null) {
            return response;
        } else {
            throw new RuntimeException("Failed to fetch country ID for country: " + countryId);
        }
    }
}

