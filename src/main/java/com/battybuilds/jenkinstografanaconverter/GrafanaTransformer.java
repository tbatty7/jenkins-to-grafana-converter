package com.battybuilds.jenkinstografanaconverter;

import java.util.Arrays;
import java.util.Map;

public class GrafanaTransformer {

    public GrafanaRequest transform(Map body) {
        return new GrafanaRequest("", Arrays.asList("production"));
    }
}
