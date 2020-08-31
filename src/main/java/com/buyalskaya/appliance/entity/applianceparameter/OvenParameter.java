package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValidatorFactory;

import java.util.function.Predicate;

public enum OvenParameter implements Predicate<String> {
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
    CAPACITY {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isCapacityValid(value);
        }
    },
    DEPTH {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isDepthValid(value);
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