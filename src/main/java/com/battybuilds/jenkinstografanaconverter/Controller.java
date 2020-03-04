package com.battybuilds.jenkinstografanaconverter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    private GrafanaService service;

    public Controller(GrafanaService service) {
        this.service = service;
    }

    @PostMapping("/jenkins-build")
    public ResponseEntity<String> receiveBuild(@RequestBody Map body) {
        System.out.println("Build-----------------" + body);
        System.out.println("Deserialization????????? - " + body.get("jobName"));
        GrafanaTransformer transformer = new GrafanaTransformer();
        GrafanaRequest transformedRequest = transformer.transform(body);

        return ResponseEntity.ok("got it");
    }

}
