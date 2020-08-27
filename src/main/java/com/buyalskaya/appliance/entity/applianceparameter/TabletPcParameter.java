package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValueValidator;

import java.util.function.Predicate;

public enum TabletPcParameter implements Predicate<String> {
    BATTERY_CAPACITY {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isBatteryCapacityValid(value);
        }
    },
    DISPLAY_INCHES {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isDisplayInchesValid(value);
        }
    },
    MEMORY_ROM {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isMemoryRomValid(value);
        }
    },
    FLASH_MEMORY_CAPACITY {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isFlashMemoryCapacityValid(value);
        }
    },
    COLOR {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isColorValid(value);
        }
    }
}