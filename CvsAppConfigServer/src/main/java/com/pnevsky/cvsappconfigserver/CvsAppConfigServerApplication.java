package com.pnevsky.cvsappconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CvsAppConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvsAppConfigServerApplication.class, args);
    }

}
