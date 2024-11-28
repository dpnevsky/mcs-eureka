package com.pnevsky.mscurriculumvitae.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                if (methodKey.contains("fetchCountryName")) {
                    return new ResponseStatusException(HttpStatusCode.valueOf(400), "400 Course service is not available");
                }
                break;
            case 404:
                if (methodKey.contains("fetchCountryName")) {
                    return new ResponseStatusException(HttpStatusCode.valueOf(404), "404 Course service is not available");
                }
                break;
            default: return new Exception(response.reason());
        }
        return null;
    }
}
