package com.buyalskaya.appliance.entity;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.creator.impl.*;
import com.buyalskaya.appliance.entity.applianceparameter.*;

import java.util.function.BiPredicate;

public enum ApplianceType implements BiPredicate<String, String> {
    OVEN(new OvenFactory(), OvenParameter.values()) {
        @Override
        public boolean test(String parameterName, String parameterValue) {
            return OvenParameter.valueOf(parameterName.toUpperCase()).test(parameterValue);
        }
    },
    LAPTOP(new LaptopFactory(), LaptopParameter.values()) {
        @Override
        public boolean test(String parameterName, String parameterValue) {
            return LaptopParameter.valueOf(parameterName.toUpperCase()).test(parameterValue);
        }
    },
    REFRIGERATOR(new RefrigeratorFactory(), RefrigeratorParameter.values()) {
        @Override
        public boolean test(String parameterName, String parameterValue) {
            return RefrigeratorParameter.valueOf(parameterName.toUpperCase()).test(parameterValue);
        }
    },
    VACUUMCLEANER(new VacuumCleanerFactory(), OvenParameter.values()) {
        @Override
        public boolean test(String parameterName, String parameterValue) {
            return VacuumCleanerParameter.valueOf(parameterName.toUpperCase()).test(parameterValue);
        }
    },
    TABLETPC(new TabletPcFactory(), TabletPcParameter.values()) {
        @Override
        public boolean test(String parameterName, String parameterValue) {
            return TabletPcParameter.valueOf(parameterName.toUpperCase()).test(parameterValue);
        }
    },
    SPEAKERS(new SpeakersFactory(), OvenParameter.values()) {
        @Override
        public boolean test(String parameterName, String parameterValue) {
            return SpeakersParameter.valueOf(parameterName.toUpperCase()).test(parameterValue);
        }
    };

    private ApplianceFactory applianceFactory;
    private Enum[] parameter;

    ApplianceType(ApplianceFactory applianceFactory, Enum[] parameter) {
        this.applianceFactory = applianceFactory;
        this.parameter = parameter;
    }

    public ApplianceFactory getApplianceFactory() {
        return applianceFactory;
    }

    public Enum[] getParameter() {
        return parameter;
    }
}