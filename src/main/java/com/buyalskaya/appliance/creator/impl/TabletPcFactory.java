package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.ApplianceColor;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;
import com.buyalskaya.appliance.entity.impl.TabletPc;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.Arrays;
import java.util.Map;

public class TabletPcFactory implements ApplianceFactory {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) throws ServiceException {
        TabletPc tabletPc = new TabletPc();
        boolean isValid = true;
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            String parameterName = parameter.getKey().toUpperCase();
            isValid = Arrays.stream(SearchCriteria.TabletPC.values())
                    .filter(p -> p.name().equals(parameterName))
                    .anyMatch(c -> c.test(parameter.getValue()));
            if (!isValid) {
                throw new ServiceException("Incorrect data in File");
            }
            addParameter(tabletPc, SearchCriteria.TabletPC.valueOf(parameterName), parameter.getValue());
        }
        return tabletPc;
    }

    private void addParameter(TabletPc tabletPc, SearchCriteria.TabletPC parameterName, String parameterValue) {
        switch (parameterName) {
            case BATTERY_CAPACITY:
                double batteryCapacity = Double.parseDouble(parameterValue);
                tabletPc.setBatteryCapacity(batteryCapacity);
                break;
            case DISPLAY_INCHES:
                int displayInches = Integer.parseInt(parameterValue);
                tabletPc.setDisplayInches(displayInches);
                break;
            case MEMORY_ROM:
                int memoryRom = Integer.parseInt(parameterValue);
                tabletPc.setMemoryRom(memoryRom);
                break;
            case FLASH_MEMORY_CAPACITY:
                int flashMemoryCapacity = Integer.parseInt(parameterValue);
                tabletPc.setFlashMemoryCapacity(flashMemoryCapacity);
                break;
            case COLOR:
                ApplianceColor applianceColor = ApplianceColor.valueOf(parameterValue.toUpperCase());
                tabletPc.setColor(applianceColor);
                break;
        }
    }
}