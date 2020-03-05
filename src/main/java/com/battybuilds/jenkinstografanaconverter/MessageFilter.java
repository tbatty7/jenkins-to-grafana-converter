package com.battybuilds.jenkinstografanaconverter;

import java.util.Map;

public class MessageFilter {
    public boolean isUseful(Map body) {
        Object buildStatus = body.get("result");
        System.out.println("Result was [" + buildStatus + "]");
        return !buildStatus.equals("INPROGRESS");
    }
}
