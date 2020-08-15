package com.buyalskaya.appliance.creator;

import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.*;

public class ApplianceCreator {
    private final static String REGEX_EQUALITY = "=";
    private final static String REGEX_STRING_PARAMETER = "([\\pL\\s]+):(\\s*(\\pL+[_\\pL]*)\\s*=\\s*([\\pL\\d.-])[\\s,]*)+";

    public static Appliance createAppliance(String applianceType, Map<String, String> parameters)
            throws ServiceException {
        ApplianceFactory applianceFactory = null;
        if (applianceType != null) {
            applianceFactory = Arrays.stream(ApplianceType.values())
                    .filter(p -> p.name().equals(applianceType.toUpperCase()))
                    .findFirst()
                    .map(ApplianceType::getApplianceFactory).get();
        }
        return applianceFactory.createAppliance(parameters);
    }
}