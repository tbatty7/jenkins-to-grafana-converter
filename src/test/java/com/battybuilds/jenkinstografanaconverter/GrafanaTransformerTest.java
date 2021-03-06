package com.battybuilds.jenkinstografanaconverter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrafanaTransformerTest {

    @Test
    void addsJobNameJobNumberAndResultToRequest() {
        GrafanaTransformer grafanaTransformer = new GrafanaTransformer();
        HashMap<Object, Object> jsonBody = new HashMap<>();
        jsonBody.put("jobName", "JOB-1");
        jsonBody.put("number", "22");
        jsonBody.put("result", "FAILURE");
        GrafanaRequest transformedRequest = grafanaTransformer.transform(jsonBody);
        assertEquals("Deployment JOB-1 / 22 - FAILURE", transformedRequest.what);
    }
}
