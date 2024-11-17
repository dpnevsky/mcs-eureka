package com.pnevsky.mscountry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsCountryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCountryApplication.class, args);
    }

}
