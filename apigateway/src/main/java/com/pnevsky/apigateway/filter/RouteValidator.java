//package com.pnevsky.apigateway.filter;
//
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.function.Predicate;
//
//@Component
//public class RouteValidator {
//
//    private static final List<String> openApiEndpoints = List.of(
//            "/auth/login",
//            "/auth/register",
//            "/public"
//    );
//
//    public Predicate<ServerHttpRequest> isSecured = request ->
//            openApiEndpoints.stream()
//                    .noneMatch(uri -> request.getURI().getPath().startsWith(uri));
//}
