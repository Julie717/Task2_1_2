package com.buyalskaya.appliance.creator;

import com.buyalskaya.appliance.creator.impl.*;

public enum ApplianceType {
    OVEN(new OvenFactory()),
    LAPTOP(new LaptopFactory()),
    REFRIGERATOR(new RefrigeratorFactory()),
    VACUUMCLEANER(new VacuumCleanerFactory()),
    TABLETPC(new TabletPcFactory()),
    SPEAKERS(new SpeakersFactory());

    private ApplianceFactory applianceFactory;

    ApplianceType(ApplianceFactory applianceFactory) {
        this.applianceFactory = applianceFactory;
    }

    public ApplianceFactory getApplianceFactory() {
        return applianceFactory;
    }
}