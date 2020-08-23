package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.impl.TabletPc;

import java.util.Map;

public class TabletPcFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        TabletPc tabletPc = new TabletPc();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            tabletPc.setParameter(parameter.getKey(), parameter.getValue());
        }
        return tabletPc;
    }
}