package com.battybuilds.jenkinstografanaconverter;

import java.util.List;

public class GrafanaRequest {
    String what;
    List<String> tags;

    public GrafanaRequest(String what, List<String> tags) {
        this.what = what;
        this.tags = tags;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhat() {
        return what;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}
