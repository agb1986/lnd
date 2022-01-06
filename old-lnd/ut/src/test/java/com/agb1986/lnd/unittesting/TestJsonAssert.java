package com.agb1986.lnd.unittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class TestJsonAssert {
    
    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quanity\":100}";

    @Test
    void jsonAssert() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quanity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
}
