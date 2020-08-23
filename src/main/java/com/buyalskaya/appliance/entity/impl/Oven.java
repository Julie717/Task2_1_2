package com.buyalskaya.appliance.entity.impl;

import com.buyalskaya.appliance.entity.KitchenAppliance;
import com.buyalskaya.appliance.entity.applianceparameter.OvenParameter;

import java.util.StringJoiner;

public class Oven extends KitchenAppliance {
    private double depth;
    private double capacity;

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setParameter(String parameterName, String parameterValue) {
        OvenParameter ovenParameter = OvenParameter.valueOf(parameterName.toUpperCase());
        switch (ovenParameter) {
            case POWER_CONSUMPTION:
                double powerConsumption = Double.parseDouble(parameterValue);
                setPowerConsumption(powerConsumption);
                break;
            case WEIGHT:
                double weight = Double.parseDouble(parameterValue);
                setWeight(weight);
                break;
            case CAPACITY:
                double capacity = Double.parseDouble(parameterValue);
                setCapacity(capacity);
                break;
            case DEPTH:
                double depth = Double.parseDouble(parameterValue);
                setDepth(depth);
                break;
            case HEIGHT:
                double height = Double.parseDouble(parameterValue);
                setHeight(height);
                break;
            case WIDTH:
                double width = Double.parseDouble(parameterValue);
                setWidth(width);
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
        Oven oven = (Oven) obj;
        return (depth == oven.depth) && (capacity == oven.capacity);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) depth + (int) capacity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("capacity=" + capacity)
                .add("depth=" + depth)
                .toString();
    }
}