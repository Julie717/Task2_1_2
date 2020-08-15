package com.buyalskaya.appliance.entity.criteria;

import com.buyalskaya.appliance.service.validation.ValueValidator;

import java.util.function.Predicate;

public final class SearchCriteria {
    public static enum Oven implements Predicate<String> {
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

    public static enum Laptop implements Predicate<String> {
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

    public static enum Refrigerator  implements Predicate<String>{
        POWER_CONSUMPTION{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isPowerConsumptionValid(value);
            }
        },
        WEIGHT{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isWeightValid(value);
            }
        },
        FREEZER_CAPACITY{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isFreezerCapacityValid(value);
            }
        },
        OVERALL_CAPACITY{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isOverallCapacityValid(value);
            }
        },
        HEIGHT{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isHeightValid(value);
            }
        },
        WIDTH{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isWidthValid(value);
            }
        }
    }

    public static enum VacuumCleaner  implements Predicate<String>{
        POWER_CONSUMPTION{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isPowerConsumptionValid(value);
            }
        },
        FILTER_TYPE{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isFilterTypeValid(value);
            }
        },
        BAG_TYPE{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isBagTypeValid(value);
            }
        },
        WAND_TYPE{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isWandTypeValid(value);
            }
        },
        MOTOR_SPEED_REGULATION{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isMotorSpeedRegulationValid(value);
            }
        },
        CLEANING_WIDTH{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isCleaningWidthValid(value);
            }
        }
    }

    public static enum TabletPC implements Predicate<String> {
        BATTERY_CAPACITY{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isBatteryCapacityValid(value);
            }
        },
        DISPLAY_INCHES{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isDisplayInchesValid(value);
            }
        },
        MEMORY_ROM{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isMemoryRomValid(value);
            }
        },
        FLASH_MEMORY_CAPACITY{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isFlashMemoryCapacityValid(value);
            }
        },
        COLOR{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isColorValid(value);
            }
        }
    }

    public static enum Speakers  implements Predicate<String>{
        POWER_CONSUMPTION{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isPowerConsumptionValid(value);
            }
        },
        NUMBER_OF_SPEAKERS{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isNumberOfSpeakersValid(value);
            }
        },
        FREQUENCY_RANGE{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isFrequencyRangeValid(value);
            }
        },
        CORD_LENGTH{
            @Override
            public boolean test(String value) {
                ValueValidator valueValidator = new ValueValidator();
                return valueValidator.isCordLengthValid(value);
            }
        }
    }

    private SearchCriteria() {
    }
}