package com.cisco.mac;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.cli.*;
import org.apache.http.HttpResponse;

import java.io.*;
import java.util.logging.Logger;

public class Opps {
    private static final Logger LOGGER = Logger.getLogger(Opps.class.getName());

    public static void main(String[] args) throws IOException, ParseException {
        Helper helper = new Helper();
        ConnectionTemplate templateBuilder = new ConnectionTemplate(
                helper.buildUpParser(args).get("pass"),
                helper.buildUpParser(args).get("mac")
        );
        if (templateBuilder.isReady()) {
            HttpResponse response = templateBuilder.queryApi();
            StringBuilder result = helper.formatResponse(response);
            JsonNode actualObj = helper.stringToJson(result);
            if (actualObj.get("actualObj") != null) {
                LOGGER.info(actualObj.get("vendorDetails").get("companyName").textValue());
            } else {
                LOGGER.info(actualObj.textValue());
            }
        } else {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("mac-checker", helper.getOptions());
        }
    }


}

