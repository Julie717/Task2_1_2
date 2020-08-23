package com.buyalskaya.appliance.creator;

import com.buyalskaya.appliance.entity.Appliance;

import java.util.Map;

public interface ApplianceFactory {
    Appliance createAppliance(Map<String,String> parameters);
}