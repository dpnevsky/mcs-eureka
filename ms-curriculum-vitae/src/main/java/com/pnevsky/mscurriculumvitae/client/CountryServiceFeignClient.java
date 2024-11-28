package com.pnevsky.mscurriculumvitae.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COUNTRY-SERVICE")
public interface CountryServiceFeignClient {

    @GetMapping("countries/country-name/{countryId}")
//    @CircuitBreaker(name = "country-service", fallbackMethod = "fetchCountryNameFallback")
    @Retry(name = "country-service", fallbackMethod = "fetchCountryNameFallback")
    String fetchCountryName(@PathVariable Long countryId);


    @GetMapping("countries/country-id/{countryName}")
    Long fetchCountryId(@PathVariable String countryName);

    default String fetchCountryNameFallback(Long countryId, Throwable exception){
        System.out.println("countryName: " + countryId);
        System.out.println("exception: " + exception);
        return "DefaultName";
    }
}




