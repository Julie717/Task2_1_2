package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.impl.Speakers;
import java.util.Map;

public class SpeakersFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        Speakers speakers = new Speakers();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            speakers.setParameter(parameter.getKey(),parameter.getValue());
        }
        return speakers;
    }
}