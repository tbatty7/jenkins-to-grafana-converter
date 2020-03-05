package com.battybuilds.jenkinstografanaconverter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
class GrafanaServiceTest {

    @Autowired
    GrafanaService service;

    @Test
    void canSendToGrafana() {
        GrafanaRequest request = new GrafanaRequest("from service", Arrays.asList("production"));
        try {
            service.sendToGrafana(request);
        } catch (HttpClientErrorException e) {
            System.out.println("++++++++++++++++++++++++" + e.getResponseBodyAsString());
            throw e;
        }
    }
}
