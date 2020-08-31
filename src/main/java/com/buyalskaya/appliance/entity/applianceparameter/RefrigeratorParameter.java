package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValidatorFactory;

import java.util.function.Predicate;

public enum RefrigeratorParameter implements Predicate<String> {
    POWER_CONSUMPTION {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isPowerConsumptionValid(value);
        }
    },
    WEIGHT {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isWeightValid(value);
        }
    },
    FREEZER_CAPACITY {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isFreezerCapacityValid(value);
        }
    },
    OVERALL_CAPACITY {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isOverallCapacityValid(value);
        }
    },
    HEIGHT {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isHeightValid(value);
        }
    },
    WIDTH {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isWidthValid(value);
        }
    }
}