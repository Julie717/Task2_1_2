package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.impl.Laptop;

import java.util.Map;

public class LaptopFactory implements ApplianceFactory {

    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        Laptop laptop = new Laptop();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            laptop.setParameter(parameter.getKey(), parameter.getValue());
        }
        return laptop;
    }
}