package com.buyalskaya.appliance.entity.impl;

import com.buyalskaya.appliance.entity.ElectricalAppliance;
import com.buyalskaya.appliance.entity.applianceparameter.SpeakersParameter;

import java.util.StringJoiner;

public class Speakers extends ElectricalAppliance {
    private final static String REGEX_DASH = "-";
    private int numberOfSpeakers;
    private double startFrequencyRange;
    private double endFrequencyRange;
    private double cordLength;

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public double getStartFrequencyRange() {
        return startFrequencyRange;
    }

    public void setStartFrequencyRange(double startFrequencyRange) {
        this.startFrequencyRange = startFrequencyRange;
    }

    public double getEndFrequencyRange() {
        return endFrequencyRange;
    }

    public void setEndFrequencyRange(double endFrequencyRange) {
        this.endFrequencyRange = endFrequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    @Override
    public void setParameter(String parameterName, String parameterValue) {
        SpeakersParameter speakersParameter = SpeakersParameter.valueOf(parameterName.toUpperCase());
        switch (speakersParameter) {
            case POWER_CONSUMPTION:
                double powerConsumption = Double.parseDouble(parameterValue);
                setPowerConsumption(powerConsumption);
                break;
            case NUMBER_OF_SPEAKERS:
                int numberOfSpeakers = Integer.parseInt(parameterValue);
                setNumberOfSpeakers(numberOfSpeakers);
                break;
            case FREQUENCY_RANGE:
                String[] frequencies = parameterValue.split(REGEX_DASH);
                double startFrequencyRange = Double.parseDouble(frequencies[0]);
                double endFrequencyRange = Double.parseDouble(frequencies[1]);
                setStartFrequencyRange(startFrequencyRange);
                setEndFrequencyRange(endFrequencyRange);
                break;
            case CORD_LENGTH:
                int cordLength = Integer.parseInt(parameterValue);
                setCordLength(cordLength);
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Speakers speaker = (Speakers) obj;
        return (numberOfSpeakers == speaker.numberOfSpeakers) &&
                (startFrequencyRange == speaker.startFrequencyRange) &&
                (endFrequencyRange == speaker.endFrequencyRange) &&
                (cordLength == speaker.cordLength);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + numberOfSpeakers + (int) startFrequencyRange + (int) endFrequencyRange + (int) cordLength;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add(super.toString())
                .add("numberOfSpeakers=" + numberOfSpeakers)
                .add("startFrequencyRange=" + startFrequencyRange)
                .add("endFrequencyRange=" + endFrequencyRange)
                .add("cordLength=" + cordLength)
                .toString();
    }
}