package com.battybuilds.jenkinstografanaconverter;

public class GrafanaRequest {
    public GrafanaRequest(String what, String[] tags) {
        this.what = what;
        this.tags = tags;
    }

    String what;

    String[] tags;
}
