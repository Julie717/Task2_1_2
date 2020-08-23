package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.impl.Refrigerator;

import java.util.Map;

public class RefrigeratorFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        Refrigerator refrigerator = new Refrigerator();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            refrigerator.setParameter(parameter.getKey(), parameter.getValue());
        }
        return refrigerator;
    }
}