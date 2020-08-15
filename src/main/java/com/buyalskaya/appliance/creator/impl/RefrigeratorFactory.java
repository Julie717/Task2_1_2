package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;
import com.buyalskaya.appliance.entity.impl.Refrigerator;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.Arrays;
import java.util.Map;

public class RefrigeratorFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) throws ServiceException {
        Refrigerator refrigerator = new Refrigerator();
        boolean isValid = true;
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            String parameterName = parameter.getKey().toUpperCase();
            isValid = Arrays.stream(SearchCriteria.Refrigerator.values())
                    .filter(p -> p.name().equals(parameterName))
                    .anyMatch(c -> c.test(parameter.getValue()));
            if (!isValid) {
                throw new ServiceException("Incorrect data in File");
            }
            addParameter(refrigerator, SearchCriteria.Refrigerator.valueOf(parameterName), parameter.getValue());
        }
        return refrigerator;
    }

    private void addParameter(Refrigerator refrigerator, SearchCriteria.Refrigerator parameterName, String parameterValue) {
        switch (parameterName) {
            case POWER_CONSUMPTION:
                double powerConsumption = Double.parseDouble(parameterValue);
                refrigerator.setPowerConsumption(powerConsumption);
                break;
            case WEIGHT:
                double weight = Double.parseDouble(parameterValue);
                refrigerator.setWeight(weight);
                break;
            case FREEZER_CAPACITY:
                double freezerCapacity = Double.parseDouble(parameterValue);
                refrigerator.setFreezerCapacity(freezerCapacity);
                break;
            case OVERALL_CAPACITY:
                double overallCapacity = Double.parseDouble(parameterValue);
                refrigerator.setOverallCapacity(overallCapacity);
                break;
            case HEIGHT:
                double height = Double.parseDouble(parameterValue);
                refrigerator.setHeight(height);
                break;
            case WIDTH:
                double width = Double.parseDouble(parameterValue);
                refrigerator.setWidth(width);
                break;
        }
    }
}