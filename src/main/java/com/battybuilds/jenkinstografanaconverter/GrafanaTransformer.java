package com.battybuilds.jenkinstografanaconverter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GrafanaTransformer {

    public GrafanaRequest transform(Map body) {
        String jobName = (String) body.get("jobName");
        String buildResult = (String) body.get("result");

        String message = "Deployed " + jobName + " / " + body.get("number") + " - " + buildResult;
        List<String> tags = Arrays.asList("production", jobName);

        return new GrafanaRequest(message, tags);
    }
}
