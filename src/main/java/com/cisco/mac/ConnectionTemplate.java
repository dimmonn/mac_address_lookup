package com.cisco.mac;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ConnectionTemplate {
    private String api_key;
    private String mac;

    public ConnectionTemplate(String api_key, String mac) {
        this.api_key = api_key;
        this.mac = mac;
    }

    HttpResponse queryApi() throws IOException {
        Request request = Request.Get("https://api.macaddress.io/v1?apiKey=" + api_key + "&output=json&search=" + mac);
        return request
                .execute()
                .returnResponse();
    }

    boolean isReady() {
        return api_key != null && mac != null && !api_key.isEmpty() && !mac.isEmpty();
    }
}
