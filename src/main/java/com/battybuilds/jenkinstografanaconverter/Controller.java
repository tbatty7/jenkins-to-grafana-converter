package com.battybuilds.jenkinstografanaconverter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/jenkins-build")
    public ResponseEntity<String> receiveBuild(@RequestBody String body) {
        System.out.println("Build-----------------" + body);
        return ResponseEntity.ok("got it");
    }

}
