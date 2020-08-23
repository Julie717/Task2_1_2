package com.buyalskaya.appliance.entity.impl;

import com.buyalskaya.appliance.entity.ApplianceColor;
import com.buyalskaya.appliance.entity.ComputerAppliance;
import com.buyalskaya.appliance.entity.applianceparameter.TabletPcParameter;

import java.util.StringJoiner;

public class TabletPc extends ComputerAppliance {
    private int flashMemoryCapacity;
    private ApplianceColor color;

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public ApplianceColor getColor() {
        return color;
    }

    public void setColor(ApplianceColor color) {
        this.color = color;
    }

    @Override
    public void setParameter(String parameterName, String parameterValue) {
        TabletPcParameter tabletPcParameter = TabletPcParameter.valueOf(parameterName.toUpperCase());
        switch (tabletPcParameter) {
            case BATTERY_CAPACITY:
                double batteryCapacity = Double.parseDouble(parameterValue);
                setBatteryCapacity(batteryCapacity);
                break;
            case DISPLAY_INCHES:
                int displayInches = Integer.parseInt(parameterValue);
                setDisplayInches(displayInches);
                break;
            case MEMORY_ROM:
                int memoryRom = Integer.parseInt(parameterValue);
                setMemoryRom(memoryRom);
                break;
            case FLASH_MEMORY_CAPACITY:
                int flashMemoryCapacity = Integer.parseInt(parameterValue);
                setFlashMemoryCapacity(flashMemoryCapacity);
                break;
            case COLOR:
                ApplianceColor applianceColor = ApplianceColor.valueOf(parameterValue.toUpperCase());
                setColor(applianceColor);
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        TabletPc tabletPc = (TabletPc) obj;
        return (flashMemoryCapacity == tabletPc.flashMemoryCapacity) &&
                (color == tabletPc.color);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + flashMemoryCapacity + color.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("flashMemoryCapacity=" + flashMemoryCapacity)
                .add("color=" + color)
                .toString();
    }
}