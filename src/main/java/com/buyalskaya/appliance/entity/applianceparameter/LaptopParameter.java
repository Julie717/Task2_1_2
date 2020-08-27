package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValueValidator;

import java.util.function.Predicate;

public enum LaptopParameter implements Predicate<String> {
    BATTERY_CAPACITY{
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isBatteryCapacityValid(value);
        }
    },
    OS{
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isOsValid(value);
        }
    },
    MEMORY_ROM{
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isMemoryRomValid(value);
        }
    },
    SYSTEM_MEMORY{
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isSystemMemoryValid(value);
        }
    },
    CPU{
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isCpuValid(value);
        }
    },
    DISPLAY_INCHES{
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isDisplayInchesValid(value);
        }
    }
}