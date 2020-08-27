package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValueValidator;

import java.util.function.Predicate;

public enum SpeakersParameter implements Predicate<String> {
    POWER_CONSUMPTION {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isPowerConsumptionValid(value);
        }
    },
    NUMBER_OF_SPEAKERS {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isNumberOfSpeakersValid(value);
        }
    },
    FREQUENCY_RANGE {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isFrequencyRangeValid(value);
        }
    },
    CORD_LENGTH {
        @Override
        public boolean test(String value) {
            ValueValidator valueValidator = new ValueValidator();
            return valueValidator.isCordLengthValid(value);
        }
    }
}