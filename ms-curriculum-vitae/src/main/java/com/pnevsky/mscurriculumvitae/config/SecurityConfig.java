//package com.pnevsky.mscurriculumvitae.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
//import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
//
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//
//@Configuration
////@EnableWebFluxSecurity
//public class SecurityConfig {
//
////    @Value("${spring.security.oauth2.client.provider.keycloak.issuer-uri}")
////    private String ISSUER;
//////
////    @Bean
////    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
////        http.csrf().disable()
////                .authorizeExchange()
////                .anyExchange().authenticated()
////                .and()
////                .oauth2ResourceServer(oauth2 -> oauth2
////                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
////        return http.build();
////    }
////
////    @Bean
////    public ReactiveJwtAuthenticationConverter jwtAuthenticationConverter(){
////        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
////        ReactiveJwtAuthenticationConverter converter = new ReactiveJwtAuthenticationConverter();
////        //for rolling
////        converter.setJwtGrantedAuthoritiesConverter(jwt -> Flux.fromIterable(jwtGrantedAuthoritiesConverter.convert(jwt)));
////        return converter;
////    }
////
////    @Bean
////    public ReactiveJwtDecoder jwtDecoder(){
////        return NimbusReactiveJwtDecoder.withJwkSetUri(ISSUER).build();
////    }
//
//    @Bean
//    @SuppressWarnings("unchecked")
//    public GrantedAuthoritiesMapper userAuthoritiesMapper(){
//        return (authorities) -> {
//            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
//
//            authorities.forEach(authority -> {
//                if(authority instanceof OidcUserAuthority oidcUserAuthority) {
//                    OidcUserInfo userInfo = oidcUserAuthority.getUserInfo();
//                    Map<String, Object> realmAccess = userInfo.getClaim("realm_access");
//                    Collection<String> realmRoles;
//                    if (realmAccess != null
//                    && (realmRoles = (Collection<String>) realmAccess.get("roles")) != null) {
//                        realmRoles
//                                .forEach(role -> mappedAuthorities.add(new SimpleGrantedAuthority(role)));
//                    }
//
//
//                }
//            });
//            return mappedAuthorities;
//        };
//
//    }
//
//}
