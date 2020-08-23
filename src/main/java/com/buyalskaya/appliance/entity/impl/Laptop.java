package com.buyalskaya.appliance.entity.impl;

import com.buyalskaya.appliance.entity.ComputerAppliance;
import com.buyalskaya.appliance.entity.ComputerOperationSystem;
import com.buyalskaya.appliance.entity.applianceparameter.LaptopParameter;

import java.util.StringJoiner;

public class Laptop extends ComputerAppliance {
    private ComputerOperationSystem operationSystem;
    private int systemMemory;
    private double cpu;

    public ComputerOperationSystem getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(ComputerOperationSystem operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(int systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    @Override
    public void setParameter(String parameterName, String parameterValue) {
        LaptopParameter laptopParameter=LaptopParameter.valueOf(parameterName.toUpperCase());
        switch (laptopParameter) {
            case BATTERY_CAPACITY:
                double batteryCapacity = Double.parseDouble(parameterValue);
                setBatteryCapacity(batteryCapacity);
                break;
            case OS:
                ComputerOperationSystem os = ComputerOperationSystem
                        .valueOf(parameterValue.toUpperCase());
                setOperationSystem(os);
                break;
            case MEMORY_ROM:
                int memoryRom = Integer.parseInt(parameterValue);
                setMemoryRom(memoryRom);
                break;
            case SYSTEM_MEMORY:
                int systemRom = Integer.parseInt(parameterValue);
                setSystemMemory(systemRom);
                break;
            case CPU:
                double cpu = Double.parseDouble(parameterValue);
                setCpu(cpu);
                break;
            case DISPLAY_INCHES:
                int displayInches = Integer.parseInt(parameterValue);
                setDisplayInches(displayInches);
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
        Laptop laptop = (Laptop) obj;
        return (operationSystem == laptop.operationSystem) &&
                (systemMemory == laptop.systemMemory) &&
                (cpu == laptop.cpu);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + operationSystem.hashCode() + systemMemory + (int) cpu;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("operationSystem=" + operationSystem)
                .add("systemMemory=" + systemMemory)
                .add("cpu=" + cpu)
                .toString();
    }
}