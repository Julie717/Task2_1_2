package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValueValidator;

import java.util.function.Predicate;

public enum OvenParameter implements Predicate<String> {
    POWER_CONSUMPTION {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isPowerConsumptionValid(value);
        }
    },
    WEIGHT {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isWeightValid(value);
        }
    },
    CAPACITY {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isCapacityValid(value);
        }
    },
    DEPTH {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isDepthValid(value);
        }
    },
    HEIGHT {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isHeightValid(value);
        }
    },
    WIDTH {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isWidthValid(value);
        }
    }
}