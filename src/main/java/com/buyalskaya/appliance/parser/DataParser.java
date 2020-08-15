package com.buyalskaya.appliance.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    private final static String REGEX_APPLIANCE_NAME = "\\s*(\\pL.+)\\s*:";
    private final static String REGEX_APPLIANCE_PARAMETER = "([\\pL_]+)\\s*=\\s*([\\pL\\d.-]+)";

    public String applianceTypeParse(String appliance) {
        Pattern pattern = Pattern.compile(REGEX_APPLIANCE_NAME);
        Matcher matcher = pattern.matcher(appliance);
        String applianceType = new String();
        if (matcher.find()) {
            applianceType = matcher.group(1).trim();
        }
        return applianceType;
    }

    public Map<String, String> applianceParametersParse(String appliance) {
        Map<String, String> parameters = new HashMap<>();
        Pattern pattern = Pattern.compile(REGEX_APPLIANCE_PARAMETER);
        Matcher matcher = pattern.matcher(appliance);
        while (matcher.find()) {
            parameters.put(matcher.group(1).trim(), matcher.group(2).trim());
        }
        return parameters;
    }
}