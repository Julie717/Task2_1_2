package com.buyalskaya.appliance.creator;

import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.ApplianceType;
import com.buyalskaya.appliance.parser.DataParser;

import java.util.*;

public class ApplianceCreator {

    public static Appliance createAppliance(String appliance) {
        DataParser dataParser = new DataParser();
        String applianceType = dataParser.applianceTypeParse(appliance);
        Map<String, String> parameters = dataParser.applianceParametersParse(appliance);
        ApplianceFactory applianceFactory = Arrays.stream(ApplianceType.values())
                .filter(p -> p.name().equals(applianceType.toUpperCase()))
                .findFirst()
                .map(ApplianceType::getApplianceFactory).get();
        return applianceFactory.createAppliance(parameters);
    }
}