package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValidatorFactory;

import java.util.function.Predicate;

public enum LaptopParameter implements Predicate<String> {
    BATTERY_CAPACITY {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isBatteryCapacityValid(value);
        }
    },
    OS {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isOsValid(value);
        }
    },
    MEMORY_ROM {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isMemoryRomValid(value);
        }
    },
    SYSTEM_MEMORY {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isSystemMemoryValid(value);
        }
    },
    CPU {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isCpuValid(value);
        }
    },
    DISPLAY_INCHES {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isDisplayInchesValid(value);
        }
    }
}