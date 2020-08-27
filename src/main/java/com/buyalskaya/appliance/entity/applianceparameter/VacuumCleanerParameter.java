package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValueValidator;

import java.util.function.Predicate;

public enum VacuumCleanerParameter implements Predicate<String> {
    POWER_CONSUMPTION {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isPowerConsumptionValid(value);
        }
    },
    FILTER_TYPE {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isFilterTypeValid(value);
        }
    },
    BAG_TYPE {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isBagTypeValid(value);
        }
    },
    WAND_TYPE {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isWandTypeValid(value);
        }
    },
    MOTOR_SPEED_REGULATION {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isMotorSpeedRegulationValid(value);
        }
    },
    CLEANING_WIDTH {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isCleaningWidthValid(value);
        }
    }
}