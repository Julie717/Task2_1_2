package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.impl.Oven;

import java.util.Map;

public class OvenFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        Oven oven = new Oven();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            oven.setParameter(parameter.getKey(), parameter.getValue());
        }
        return oven;
    }
}