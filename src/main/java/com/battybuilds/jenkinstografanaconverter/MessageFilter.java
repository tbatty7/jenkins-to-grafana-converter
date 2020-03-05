package com.battybuilds.jenkinstografanaconverter;

import java.util.List;
import java.util.Map;

public class MessageFilter {

    private List<String> productionJobs;

    public MessageFilter(List<String> productionJobs) {
        this.productionJobs = productionJobs;
    }

    public boolean isUseful(Map body) {
        Object buildStatus = body.get("result");
        System.out.println("Result was [" + buildStatus + "]");
        return isBuildCompleted(buildStatus) && isProductionDeployment(body);
    }

    private boolean isProductionDeployment(Map body) {
        Object jenkinsJobName = body.get("jobName");

        boolean isRecognizedProductionJob = productionJobs.contains(jenkinsJobName);
        System.out.println("Is it in List of Jobs: " + isRecognizedProductionJob);
        return isRecognizedProductionJob;
    }

    private boolean isBuildCompleted(Object buildStatus) {
        return !buildStatus.equals("INPROGRESS");
    }
}
