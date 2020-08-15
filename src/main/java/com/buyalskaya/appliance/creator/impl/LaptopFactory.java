package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.ComputerOperationSystem;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;
import com.buyalskaya.appliance.entity.impl.Laptop;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.Arrays;
import java.util.Map;

public class LaptopFactory implements ApplianceFactory {

    @Override
    public Appliance createAppliance(Map<String, String> parameters) throws ServiceException {
        Laptop laptop = new Laptop();
        boolean isValid = true;
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            String parameterName = parameter.getKey().toUpperCase();
            isValid = Arrays.stream(SearchCriteria.Laptop.values())
                    .filter(p -> p.name().equals(parameterName))
                    .anyMatch(c -> c.test(parameter.getValue()));
            if (!isValid) {
                throw new ServiceException("Incorrect data in File");
            }
            addParameter(laptop,SearchCriteria.Laptop.valueOf(parameterName),parameter.getValue());
        }
        return laptop;
    }

    private void addParameter(Laptop laptop, SearchCriteria.Laptop parameterName, String parameterValue) {
        switch (parameterName) {
            case BATTERY_CAPACITY:
                double batteryCapacity = Double.parseDouble(parameterValue);
                laptop.setBatteryCapacity(batteryCapacity);
                break;
            case OS:
                ComputerOperationSystem os = ComputerOperationSystem
                        .valueOf(parameterValue.toUpperCase());
                laptop.setOperationSystem(os);
                break;
            case MEMORY_ROM:
                int memoryRom = Integer.parseInt(parameterValue);
                laptop.setMemoryRom(memoryRom);
                break;
            case SYSTEM_MEMORY:
                int systemRom = Integer.parseInt(parameterValue);
                laptop.setSystemMemory(systemRom);
                break;
            case CPU:
                double cpu = Double.parseDouble(parameterValue);
                laptop.setCpu(cpu);
                break;
            case DISPLAY_INCHES:
                int displayInches = Integer.parseInt(parameterValue);
                laptop.setDisplayInches(displayInches);
                break;
        }
    }
}