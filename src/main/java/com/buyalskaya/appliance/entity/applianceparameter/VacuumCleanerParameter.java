package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValidatorFactory;

import java.util.function.Predicate;

public enum VacuumCleanerParameter implements Predicate<String> {
    POWER_CONSUMPTION {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isPowerConsumptionValid(value);
        }
    },
    FILTER_TYPE {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isFilterTypeValid(value);
        }
    },
    BAG_TYPE {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isBagTypeValid(value);
        }
    },
    WAND_TYPE {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isWandTypeValid(value);
        }
    },
    MOTOR_SPEED_REGULATION {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isMotorSpeedRegulationValid(value);
        }
    },
    CLEANING_WIDTH {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isCleaningWidthValid(value);
        }
    }
}