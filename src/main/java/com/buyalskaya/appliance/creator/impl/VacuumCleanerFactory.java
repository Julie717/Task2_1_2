package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.impl.VacuumCleaner;

import java.util.Map;

public class VacuumCleanerFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            vacuumCleaner.setParameter(parameter.getKey(), parameter.getValue());
        }
        return vacuumCleaner;
    }
}