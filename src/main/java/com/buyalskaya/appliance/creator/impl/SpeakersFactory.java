package com.buyalskaya.appliance.creator.impl;

import com.buyalskaya.appliance.creator.ApplianceFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;
import com.buyalskaya.appliance.entity.impl.Speakers;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.Arrays;
import java.util.Map;

public class SpeakersFactory implements ApplianceFactory {
    private final static String REGEX_DASH = "-";

    @Override
    public Appliance createAppliance(Map<String, String> parameters) throws ServiceException {
        Speakers speakers = new Speakers();
        boolean isValid = true;
        for (Map.Entry<String, String> parameter : parameters.entrySet()) {
            String parameterName = parameter.getKey().toUpperCase();
            isValid = Arrays.stream(SearchCriteria.Speakers.values())
                    .filter(p -> p.name().equals(parameterName))
                    .anyMatch(c -> c.test(parameter.getValue()));
            if (!isValid) {
                throw new ServiceException("Incorrect data in File");
            }
            addParameter(speakers, SearchCriteria.Speakers.valueOf(parameterName), parameter.getValue());
        }
        return speakers;
    }

    private void addParameter(Speakers speakers, SearchCriteria.Speakers parameterName, String parameterValue) {
        switch (parameterName) {
            case POWER_CONSUMPTION:
                double powerConsumption = Double.parseDouble(parameterValue);
                speakers.setPowerConsumption(powerConsumption);
                break;
            case NUMBER_OF_SPEAKERS:
                int numberOfSpeakers = Integer.parseInt(parameterValue);
                speakers.setNumberOfSpeakers(numberOfSpeakers);
                break;
            case FREQUENCY_RANGE:
                String[] frequencies = parameterValue.split(REGEX_DASH);
                double startFrequencyRange = Double.parseDouble(frequencies[0]);
                double endFrequencyRange = Double.parseDouble(frequencies[1]);
                speakers.setStartFrequencyRange(startFrequencyRange);
                speakers.setEndFrequencyRange(endFrequencyRange);
                break;
            case CORD_LENGTH:
                int cordLength = Integer.parseInt(parameterValue);
                speakers.setCordLength(cordLength);
                break;
        }
    }
}