package com.buyalskaya.appliance.entity.applianceparameter;

import com.buyalskaya.appliance.service.validation.ValidatorFactory;

import java.util.function.Predicate;

public enum SpeakersParameter implements Predicate<String> {
    POWER_CONSUMPTION {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isPowerConsumptionValid(value);
        }
    },
    NUMBER_OF_SPEAKERS {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isNumberOfSpeakersValid(value);
        }
    },
    FREQUENCY_RANGE {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isFrequencyRangeValid(value);
        }
    },
    CORD_LENGTH {
        @Override
        public boolean test(String value) {
            return ValidatorFactory.getInstance().getValueValidator().isCordLengthValid(value);
        }
    }
}