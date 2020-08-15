package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;
import com.buyalskaya.appliance.entity.impl.Oven;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.Arrays;
import java.util.Map;

public class OvenFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) throws ServiceException {
        Oven oven = new Oven();
        boolean isValid = true;
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            String parameterName = parameter.getKey().toUpperCase();
            isValid = Arrays.stream(SearchCriteria.Oven.values())
                    .filter(p -> p.name().equals(parameterName))
                    .anyMatch(c -> c.test(parameter.getValue()));
            if (!isValid) {
                throw new ServiceException("Incorrect data in File");
            }
            addParameter(oven, SearchCriteria.Oven.valueOf(parameterName), parameter.getValue());
        }
        return oven;
    }

    private void addParameter(Oven oven, SearchCriteria.Oven parameterName, String parameterValue) {
        switch (parameterName) {
            case POWER_CONSUMPTION:
                double powerConsumption = Double.parseDouble(parameterValue);
                oven.setPowerConsumption(powerConsumption);
                break;
            case WEIGHT:
                double weight = Double.parseDouble(parameterValue);
                oven.setWeight(weight);
                break;
            case CAPACITY:
                double capacity = Double.parseDouble(parameterValue);
                oven.setCapacity(capacity);
                break;
            case DEPTH:
                double depth = Double.parseDouble(parameterValue);
                oven.setDepth(depth);
                break;
            case HEIGHT:
                double height = Double.parseDouble(parameterValue);
                oven.setHeight(height);
                break;
            case WIDTH:
                double width = Double.parseDouble(parameterValue);
                oven.setWidth(width);
                break;
        }
    }
}