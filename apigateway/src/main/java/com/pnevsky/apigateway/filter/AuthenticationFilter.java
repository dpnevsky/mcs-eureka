//package com.pnevsky.apigateway.filter;
//
//import com.pnevsky.apigateway.util.JwtUtil;
//import lombok.AllArgsConstructor;
//import org.apache.http.HttpHeaders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//
//@Component
//public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{
//
//    @Autowired
//    private RouteValidator validator;
////    @Autowired
////    private RestTemplate restTemplate;
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    public AuthenticationFilter(){
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(AuthenticationFilter.Config config) {
//        return ((exchange, chain) -> {
//            if(validator.isSecured.test(exchange.getRequest())){
//                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//                    throw new RuntimeException("Missing authorization header");
//                }
//                    String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//                if(authHeader != null && authHeader.startsWith("Bearer ")) {
//                    authHeader = authHeader.substring(7);
//                }
//                try {
//                    jwtUtil.validateToken(authHeader);
//                } catch (Exception e) {
//                    System.out.println("Invalid access");
//                throw new RuntimeException("un authorized access to application");
//                }
//            }
//        return chain.filter(exchange) ;
//        });
//    }
//
//    public static class Config {
//
//    }
//}
