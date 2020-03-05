package com.battybuilds.jenkinstografanaconverter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GrafanaService {
    public void sendToGrafana(GrafanaRequest grafanaRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("eyJrIjoiNEFkcHlUOE5BVzNLUFE2M3VGWmp0cXZ0cUx1R3dkdngiLCJuIjoiTWFpbktleSIsImlkIjoxfQ==");
        HttpEntity<GrafanaRequest> entity = new HttpEntity<>(grafanaRequest, headers);

        restTemplate.exchange("http://192.168.1.249:3000/api/annotations/graphite", HttpMethod.POST, entity, String.class);
    }
}
