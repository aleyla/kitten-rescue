package com.leyla.kittenrescue.client;

import com.leyla.kittenrescue.configuration.RestTemplateConfiguration;
import com.leyla.kittenrescue.enums.ErrorCodeEnum;
import com.leyla.kittenrescue.exception.KittenRescueApiException;
import com.leyla.kittenrescue.model.response.DirectionResponse;
import com.leyla.kittenrescue.model.response.LocationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class WhichApiClient {

    Logger log = LoggerFactory.getLogger(WhichApiClient.class);

    private final WhichApiClientConfig config;

    private final RestTemplateConfiguration restTemplateConfiguration;

    public WhichApiClient(WhichApiClientConfig config, RestTemplateConfiguration restTemplateConfiguration) {
        this.config = config;
        this.restTemplateConfiguration = restTemplateConfiguration;
    }

    public DirectionResponse getDirections(String email) {
        log.info("WhichApiClient getDirections start");
        try {
            Map<String, String> params = new HashMap<>();
            params.put("email", email);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.valueOf("application/json;charset=UTF-8"));

            HttpEntity<String> request = new HttpEntity<>(null, headers);
            var objectResponse = getRequest(getPath(config.getDirection()), params, request);

            log.info("WhichApiClient getDirections ok");
            return restTemplateConfiguration.objectMapper().convertValue(objectResponse.getBody(), DirectionResponse.class);

        }
        catch (Exception e) {
            log.error("getDirections ", e);
            throw new KittenRescueApiException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        }
    }

    public LocationResponse getLocation(String email, int x, int y) {
        log.info("WhichApiClient getLocation start");
        try {
            Map<String, String> params = new HashMap<>();
            params.put("email", email);
            params.put("x", String.valueOf(x));
            params.put("y", String.valueOf(y));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.valueOf("application/json;charset=UTF-8"));

            HttpEntity<String> request = new HttpEntity<>(null, headers);
            var objectResponse = getRequest(getPath(config.getLocation()), params, request);

            log.info("WhichApiClient getLocation ok");
            return restTemplateConfiguration.objectMapper().convertValue(objectResponse.getBody(), LocationResponse.class);
        }
        catch (Exception ex) {
            log.error("getLocation ", ex);
            throw new KittenRescueApiException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        }
    }

    private String getPath(String path) {
        return config.getPath().concat(path);
    }

    private ResponseEntity<Object> getRequest(String path, Map<String, String> params, HttpEntity<String> request) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(path);
        String url = builder.buildAndExpand(params).toUri().toString();
        log.debug("request started. url:[{}]", url);
        return restTemplateConfiguration.restTemplate().exchange(url, HttpMethod.GET, request, Object.class);
    }

}
