package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValidatorFactory;

import java.util.function.Predicate;

public enum TabletPcParameter implements Predicate<String> {
    BATTERY_CAPACITY {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isBatteryCapacityValid(value);
        }
    },
    DISPLAY_INCHES {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isDisplayInchesValid(value);
        }
    },
    MEMORY_ROM {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isMemoryRomValid(value);
        }
    },
    FLASH_MEMORY_CAPACITY {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isFlashMemoryCapacityValid(value);
        }
    },
    COLOR {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isColorValid(value);
        }
    }
}