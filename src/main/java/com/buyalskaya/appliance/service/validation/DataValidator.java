package com.buyalskaya.appliance.service.validation;

import java.util.List;
import java.util.regex.Pattern;

public class DataValidator {
    private final static String REGEX_STRING_PARAMETER ="([\\pL\\s]+):(\\s*(\\pL+[_\\pL]*)\\s*=\\s*([\\pL\\d.-])*[\\s,]*)+";

    private static boolean isStringApplianceValid(String appliance) {
        boolean isValid = false;
        if (appliance != null && !appliance.isEmpty()) {
            isValid = Pattern.matches(REGEX_STRING_PARAMETER, appliance);
        }
        return isValid;
    }

    public static boolean isStringApplianceValid(List<String> appliances) {
        boolean isValid = false;
        if (appliances != null && !appliances.isEmpty()) {
            isValid = appliances.stream().allMatch(a -> isStringApplianceValid(a));
        }
        return isValid;
    }
}