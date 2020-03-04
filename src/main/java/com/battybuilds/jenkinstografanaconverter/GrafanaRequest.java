package com.battybuilds.jenkinstografanaconverter;

import java.util.List;

public class GrafanaRequest {
    String what;
    List<String> tags;

    public GrafanaRequest(String what, List<String> tags) {
        this.what = what;
        this.tags = tags;
    }
}
