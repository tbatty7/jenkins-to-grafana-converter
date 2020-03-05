package com.battybuilds.jenkinstografanaconverter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageFilterTest {

    private final MessageFilter messageFilter = new MessageFilter();

    @Test
    void removesPendingJobEvents() {
        HashMap body = new HashMap();
        body.put("result", "INPROGRESS");
        boolean result = messageFilter.isUseful(body);
        assertEquals(false, result);
    }

    @Test
    void allowsFailedJobEvents() {
        HashMap<Object, Object> body = new HashMap<>();
        body.put("result", "FAILURE");
        boolean result = messageFilter.isUseful(body);
        assertEquals(true, result);
    }
}
