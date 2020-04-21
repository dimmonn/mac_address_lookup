package com.cisco.mac;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.*;
import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    private Options options = new Options();

    public Helper() {
        options.addOption("p", "api key", true, "enter api key");
        options.addOption("m", "mac address", true, "enter mac-address");
    }

    JsonNode stringToJson(StringBuilder result) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(result.toString());
    }

    StringBuilder formatResponse(HttpResponse response) throws IOException {
        InputStream content = response.getEntity().getContent();
        BufferedReader rd = new BufferedReader(new InputStreamReader(content));
        StringBuilder result = new StringBuilder();
        String output = "";
        while ((output = rd.readLine()) != null) {
            result.append(output);
        }
        return result;
    }

    Map<String, String> buildUpParser(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        Map<String, String> config = new HashMap<>();
        config.put("pass", cmd.getOptionValue('p'));
        config.put("mac", cmd.getOptionValue('m'));
        return config;
    }

    public Options getOptions() {
        return options;
    }
}
