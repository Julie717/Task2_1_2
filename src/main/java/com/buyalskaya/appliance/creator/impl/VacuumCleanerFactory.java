package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.FilterType;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;
import com.buyalskaya.appliance.entity.impl.VacuumCleaner;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.Arrays;
import java.util.Map;

public class VacuumCleanerFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) throws ServiceException {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        boolean isValid = true;
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            String parameterName = parameter.getKey().toUpperCase();
            isValid = Arrays.stream(SearchCriteria.VacuumCleaner.values())
                    .filter(p -> p.name().equals(parameterName))
                    .anyMatch(c -> c.test(parameter.getValue()));
            if (!isValid) {
                throw new ServiceException("Incorrect data in File");
            }
            addParameter(vacuumCleaner, SearchCriteria.VacuumCleaner.valueOf(parameterName), parameter.getValue());
        }
        return vacuumCleaner;
    }

    private void addParameter(VacuumCleaner vacuumCleaner, SearchCriteria.VacuumCleaner parameterName,
                              String parameterValue) {
        switch (parameterName) {
            case POWER_CONSUMPTION:
                double powerConsumption = Double.parseDouble(parameterValue);
                vacuumCleaner.setPowerConsumption(powerConsumption);
                break;
            case FILTER_TYPE:
                FilterType filterType = FilterType.valueOf(parameterValue.toUpperCase());
                vacuumCleaner.setFilterType(filterType);
                break;
            case BAG_TYPE:
                vacuumCleaner.setBagType(parameterValue);
                break;
            case WAND_TYPE:
                vacuumCleaner.setWandType(parameterValue);
                break;
            case MOTOR_SPEED_REGULATION:
                double motorSpeedRegulation = Double.parseDouble(parameterValue);
                vacuumCleaner.setMotorSpeedRegulation(motorSpeedRegulation);
                break;
            case CLEANING_WIDTH:
                double cleaningWidth = Double.parseDouble(parameterValue);
                vacuumCleaner.setCleaningWidth(cleaningWidth);
                break;
        }
    }
}