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
        System.out.println(body);
        MessageFilter filter = new MessageFilter(ProductionJobs.getList());
        if (filter.isUseful(body)) {
            GrafanaTransformer transformer = new GrafanaTransformer();
            GrafanaRequest transformedRequest = transformer.transform(body);
            service.sendToGrafana(transformedRequest);
        }
        return ResponseEntity.ok("got it");
    }

}
