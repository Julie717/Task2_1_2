package com.buyalskaya.appliance.service.validation;

import com.buyalskaya.appliance.entity.ApplianceColor;
import com.buyalskaya.appliance.entity.ComputerOperationSystem;
import com.buyalskaya.appliance.entity.FilterType;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValueValidator {
    private final static String REGEX_NUMBER = "\\d+";
    private final static String REGEX_FRACTION = "\\d+(.\\d+)?";
    private final static String REGEX_BAG_TYPE = "\\pL[\\pL\\d]([\\pL\\d-])*";
    private final static String REGEX_WAND_TYPE = "[\\pL-]+";
    private final static String REGEX_FREQUENCY_RANGE = "\\d+(.\\d+)?-\\d+(.\\d+)?";
    private final static String REGEX_DASH = "-";

    public boolean isPowerConsumptionValid(String powerConsumption) {
        boolean isValid = false;
        if (powerConsumption != null && !powerConsumption.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, powerConsumption);
            if (isValid) {
                int powerConsumptionNumber = Integer.parseInt(powerConsumption);
                isValid = powerConsumptionNumber >= ExtremumValueSearchCriteria.MIN_POWER_CONSUMPTION &&
                        powerConsumptionNumber <= ExtremumValueSearchCriteria.MAX_POWER_CONSUMPTION;
            }
        }
        return isValid;
    }

    public boolean isBatteryCapacityValid(String batteryCapacity) {
        boolean isValid = false;
        if (batteryCapacity != null && !batteryCapacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, batteryCapacity);
            if (isValid) {
                double batteryCapacityNumber = Double.parseDouble(batteryCapacity);
                isValid = batteryCapacityNumber >= ExtremumValueSearchCriteria.MIN_BATTERY_CAPACITY &&
                        batteryCapacityNumber <= ExtremumValueSearchCriteria.MAX_BATTERY_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isWeightValid(String weight) {
        boolean isValid = false;
        if (weight != null && !weight.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, weight);
            if (isValid) {
                double weightNumber = Double.parseDouble(weight);
                isValid = weightNumber >= ExtremumValueSearchCriteria.MIN_WEIGHT &&
                        weightNumber <= ExtremumValueSearchCriteria.MAX_WEIGHT;
            }
        }
        return isValid;
    }

    public boolean isOsValid(String os) {
        boolean isValid = false;
        if (os != null && !os.isEmpty()) {
            isValid = Arrays.stream(ComputerOperationSystem.values())
                    .anyMatch(o -> o.name().equals(os.toUpperCase()));
        }
        return isValid;
    }

    public boolean isFilterTypeValid(String filterType) {
        boolean isValid = false;
        if (filterType != null && !filterType.isEmpty()) {
            isValid = Arrays.stream(FilterType.values())
                    .anyMatch(p -> p.name().equals(filterType.toUpperCase()));
        }
        return isValid;
    }

    public boolean isDisplayInchesValid(String displayInches) {
        boolean isValid = false;
        if (displayInches != null && !displayInches.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, displayInches);
            if (isValid) {
                int displayInchesNumber = Integer.parseInt(displayInches);
                isValid = displayInchesNumber >= ExtremumValueSearchCriteria.MIN_DISPLAY_INCHES &&
                        displayInchesNumber <= ExtremumValueSearchCriteria.MAX_DISPLAY_INCHES;
            }
        }
        return isValid;
    }

    public boolean isNumberOfSpeakersValid(String numberOfSpeakers) {
        boolean isValid = false;
        if (numberOfSpeakers != null && !numberOfSpeakers.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, numberOfSpeakers);
            if (isValid) {
                int numberOfSpeakersNumber = Integer.parseInt(numberOfSpeakers);
                isValid = numberOfSpeakersNumber >= ExtremumValueSearchCriteria.MIN_NUMBER_OF_SPEAKERS &&
                        numberOfSpeakersNumber <= ExtremumValueSearchCriteria.MAX_NUMBER_OF_SPEAKERS;
            }
        }
        return isValid;
    }

    public boolean isCapacityValid(String capacity) {
        boolean isValid = false;
        if (capacity != null && !capacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, capacity);
            if (isValid) {
                double capacityNumber = Double.parseDouble(capacity);
                isValid = capacityNumber >= ExtremumValueSearchCriteria.MIN_CAPACITY &&
                        capacityNumber <= ExtremumValueSearchCriteria.MAX_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isMemoryRomValid(String memoryRom) {
        boolean isValid = false;
        if (memoryRom != null && !memoryRom.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, memoryRom);
            if (isValid) {
                int memoryRomNumber = Integer.parseInt(memoryRom);
                isValid = memoryRomNumber >= ExtremumValueSearchCriteria.MIN_MEMORY_ROM &&
                        memoryRomNumber <= ExtremumValueSearchCriteria.MAX_MEMORY_ROM;
            }
        }
        return isValid;
    }

    public boolean isFreezerCapacityValid(String capacity) {
        boolean isValid = false;
        if (capacity != null && !capacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, capacity);
            if (isValid) {
                double capacityNumber = Double.parseDouble(capacity);
                isValid = capacityNumber >= ExtremumValueSearchCriteria.MIN_FREEZER_CAPACITY &&
                        capacityNumber <= ExtremumValueSearchCriteria.MAX_FREEZER_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isDepthValid(String depth) {
        boolean isValid = false;
        if (depth != null && !depth.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, depth);
            if (isValid) {
                double capacityNumber = Double.parseDouble(depth);
                isValid = capacityNumber >= ExtremumValueSearchCriteria.MIN_DEPTH &&
                        capacityNumber <= ExtremumValueSearchCriteria.MAX_DEPTH;
            }
        }
        return isValid;
    }

    public boolean isHeightValid(String height) {
        boolean isValid = false;
        if (height != null && !height.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, height);
            if (isValid) {
                double heightNumber = Double.parseDouble(height);
                isValid = heightNumber >= ExtremumValueSearchCriteria.MIN_HEIGHT &&
                        heightNumber <= ExtremumValueSearchCriteria.MAX_HEIGHT;
            }
        }
        return isValid;
    }

    public boolean isWidthValid(String width) {
        boolean isValid = false;
        if (width != null && !width.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, width);
            if (isValid) {
                double widthNumber = Double.parseDouble(width);
                isValid = widthNumber >= ExtremumValueSearchCriteria.MIN_WIDTH &&
                        widthNumber <= ExtremumValueSearchCriteria.MAX_WIDTH;
            }
        }
        return isValid;
    }

    public boolean isSystemMemoryValid(String systemMemory) {
        boolean isValid = false;
        if (systemMemory != null && !systemMemory.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, systemMemory);
            if (isValid) {
                int systemMemoryNumber = Integer.parseInt(systemMemory);
                isValid = systemMemoryNumber >= ExtremumValueSearchCriteria.MIN_SYSTEM_MEMORY &&
                        systemMemoryNumber <= ExtremumValueSearchCriteria.MAX_SYSTEM_MEMORY;
            }
        }
        return isValid;
    }

    public boolean isOverallCapacityValid(String capacity) {
        boolean isValid = false;
        if (capacity != null && !capacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, capacity);
            if (isValid) {
                double capacityNumber = Double.parseDouble(capacity);
                isValid = capacityNumber >= ExtremumValueSearchCriteria.MIN_OVERALL_CAPACITY &&
                        capacityNumber <= ExtremumValueSearchCriteria.MAX_OVERALL_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isFlashMemoryCapacityValid(String flashMemoryCapacity) {
        boolean isValid = false;
        if (flashMemoryCapacity != null && !flashMemoryCapacity.isEmpty()) {
            isValid = Pattern.matches(REGEX_NUMBER, flashMemoryCapacity);
            if (isValid) {
                int flashMemoryCapacityNumber = Integer.parseInt(flashMemoryCapacity);
                isValid = flashMemoryCapacityNumber >= ExtremumValueSearchCriteria.MIN_FLASH_MEMORY_CAPACITY &&
                        flashMemoryCapacityNumber <= ExtremumValueSearchCriteria.MAX_FLASH_MEMORY_CAPACITY;
            }
        }
        return isValid;
    }

    public boolean isCordLengthValid(String cordLength) {
        boolean isValid = false;
        if (cordLength != null && !cordLength.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, cordLength);
            if (isValid) {
                double cordLengthNumber = Double.parseDouble(cordLength);
                isValid = cordLengthNumber >= ExtremumValueSearchCriteria.MIN_CORD_LENGTH &&
                        cordLengthNumber <= ExtremumValueSearchCriteria.MAX_CORD_LENGTH;
            }
        }
        return isValid;
    }

    public boolean isCpuValid(String cpu) {
        boolean isValid = false;
        if (cpu != null && !cpu.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, cpu);
            if (isValid) {
                double cpuNumber = Double.parseDouble(cpu);
                isValid = cpuNumber >= ExtremumValueSearchCriteria.MIN_CPU &&
                        cpuNumber <= ExtremumValueSearchCriteria.MAX_CPU;
            }
        }
        return isValid;
    }

    public boolean isMotorSpeedRegulationValid(String motorSpeedRegulation) {
        boolean isValid = false;
        if (motorSpeedRegulation != null && !motorSpeedRegulation.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, motorSpeedRegulation);
            if (isValid) {
                double motorSpeedRegulationNumber = Double.parseDouble(motorSpeedRegulation);
                isValid = motorSpeedRegulationNumber >= ExtremumValueSearchCriteria.MIN_MOTOR_SPEED_REGULATION &&
                        motorSpeedRegulationNumber <= ExtremumValueSearchCriteria.MAX_MOTOR_SPEED_REGULATION;
            }
        }
        return isValid;
    }

    public boolean isColorValid(String color) {
        boolean isValid = false;
        if (color != null && !color.isEmpty()) {
            isValid = Arrays.stream(ApplianceColor.values())
                    .anyMatch(o -> o.name().equals(color.toUpperCase()));
        }
        return isValid;
    }

    public boolean isCleaningWidthValid(String cleaningWidth) {
        boolean isValid = false;
        if (cleaningWidth != null && !cleaningWidth.isEmpty()) {
            isValid = Pattern.matches(REGEX_FRACTION, cleaningWidth);
            if (isValid) {
                double cleaningWidthNumber = Double.parseDouble(cleaningWidth);
                isValid = cleaningWidthNumber >= ExtremumValueSearchCriteria.MIN_CLEANING_WIDTH &&
                        cleaningWidthNumber <= ExtremumValueSearchCriteria.MAX_CLEANING_WIDTH;
            }
        }
        return isValid;
    }

    public boolean isBagTypeValid(String bagType) {
        boolean isValid = false;
        if (bagType != null && !bagType.isEmpty()) {
            isValid = Pattern.matches(REGEX_BAG_TYPE, bagType);
        }
        return isValid;
    }

    public boolean isWandTypeValid(String wandType) {
        boolean isValid = false;
        if (wandType != null && !wandType.isEmpty()) {
            isValid = Pattern.matches(REGEX_WAND_TYPE, wandType);
        }
        return isValid;
    }

    public boolean isFrequencyRangeValid(String frequencyRange) {
        boolean isValid = false;
        if (frequencyRange != null && !frequencyRange.isEmpty()) {
            isValid = Pattern.matches(REGEX_FREQUENCY_RANGE, frequencyRange);
            if (isValid) {
                String[] frequencies = frequencyRange.split(REGEX_DASH);
                double startFrequencyRange = Double.parseDouble(frequencies[0]);
                double endFrequencyRange = Double.parseDouble(frequencies[1]);
                isValid = startFrequencyRange >= ExtremumValueSearchCriteria.MIN_FREQUENCY &&
                        startFrequencyRange <= ExtremumValueSearchCriteria.MAX_FREQUENCY &&
                        endFrequencyRange >= ExtremumValueSearchCriteria.MIN_FREQUENCY &&
                        endFrequencyRange <= ExtremumValueSearchCriteria.MAX_FREQUENCY &&
                        startFrequencyRange <= endFrequencyRange;
            }
        }
        return isValid;
    }
}