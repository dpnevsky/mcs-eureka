package com.pnevsky.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Flux;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Value("${spring.security.oauth2.client.provider.keycloak.issuer-uri}")
    private String ISSUER;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http.csrf().disable()
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
        return http.build();
    }

    @Bean
    public ReactiveJwtAuthenticationConverter jwtAuthenticationConverter(){
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        ReactiveJwtAuthenticationConverter converter = new ReactiveJwtAuthenticationConverter();
        //for rolling
        converter.setJwtGrantedAuthoritiesConverter(jwt -> Flux.fromIterable(jwtGrantedAuthoritiesConverter.convert(jwt)));
        return converter;
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder(){
        return NimbusReactiveJwtDecoder.withJwkSetUri(ISSUER).build();
    }

}
