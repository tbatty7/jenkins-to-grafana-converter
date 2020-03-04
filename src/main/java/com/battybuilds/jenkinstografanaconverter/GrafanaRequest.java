package com.battybuilds.jenkinstografanaconverter;

public class GrafanaRequest {
    String what;
    String[] tags;

    public GrafanaRequest(String what, String[] tags) {
        this.what = what;
        this.tags = tags;
    }
}
