package com.buyalskaya.appliance.entity.impl;

import com.buyalskaya.appliance.entity.KitchenAppliance;
import com.buyalskaya.appliance.entity.applianceparameter.RefrigeratorParameter;

import java.util.StringJoiner;

public class Refrigerator extends KitchenAppliance {
    private double freezerCapacity;
    private double overallCapacity;

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    @Override
    public void setParameter(String parameterName, String parameterValue) {
        RefrigeratorParameter refrigeratorParameter = RefrigeratorParameter.valueOf(parameterName.toUpperCase());
        switch (refrigeratorParameter) {
            case POWER_CONSUMPTION:
                double powerConsumption = Double.parseDouble(parameterValue);
                setPowerConsumption(powerConsumption);
                break;
            case WEIGHT:
                double weight = Double.parseDouble(parameterValue);
                setWeight(weight);
                break;
            case FREEZER_CAPACITY:
                double freezerCapacity = Double.parseDouble(parameterValue);
                setFreezerCapacity(freezerCapacity);
                break;
            case OVERALL_CAPACITY:
                double overallCapacity = Double.parseDouble(parameterValue);
                setOverallCapacity(overallCapacity);
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
        Refrigerator refrigerator = (Refrigerator) obj;
        return (freezerCapacity == refrigerator.freezerCapacity) &&
                (overallCapacity == refrigerator.overallCapacity);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) freezerCapacity + (int) overallCapacity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("freezer_capacity=" + freezerCapacity)
                .add("overall_capacity=" + overallCapacity)
                .toString();
    }
}