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
        GrafanaRequest request = new GrafanaRequest("automated test from service", Arrays.asList("test"));
        service.sendToGrafana(request);
    }
}
