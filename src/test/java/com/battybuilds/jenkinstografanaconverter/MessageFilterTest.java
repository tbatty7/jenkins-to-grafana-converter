package com.battybuilds.jenkinstografanaconverter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageFilterTest {

    private final MessageFilter messageFilter = new MessageFilter(Arrays.asList("eighth_service"));

    @Test
    void removesPendingJobEvents() {
        HashMap body = new HashMap();
        body.put("result", "INPROGRESS");
        body.put("jobName", "eighth_service");
        boolean result = messageFilter.isUseful(body);
        assertEquals(false, result);
    }

    @Test
    void allowsFailedJobEvents() {
        HashMap<Object, Object> body = new HashMap<>();
        body.put("result", "FAILURE");
        body.put("jobName", "eighth_service");
        boolean result = messageFilter.isUseful(body);
        assertEquals(true, result);
    }

    @Test
    void doesNotAllowPreprodJobs() {
        HashMap<Object, Object> body = new HashMap<>();
        body.put("result", "FAILURE");
        body.put("jobName", "eighth_service_preprod");
        boolean result = messageFilter.isUseful(body);
        assertEquals(false, result);
    }
}
