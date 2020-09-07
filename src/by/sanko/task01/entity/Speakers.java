package by.sanko.task01.entity;

import by.sanko.task01.service.parser.DataParser;

import java.util.StringTokenizer;

public class Speakers implements Appliance {
    private double powerConsumption;
    private double numberOfSpeakers;
    private String frequencyRange;
    private double cordLength;

    public Speakers(double powerConsumption, double numberOfSpeakers, String frequencyRange, double cordLength) {
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }

    public Speakers(String input){
        StringTokenizer tokenizer = new StringTokenizer(input);
        tokenizer.nextToken();
        tokenizer.nextToken();
        DataParser parser = DataParser.getInstance();
        powerConsumption = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
        numberOfSpeakers = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
        frequencyRange = parser.parseValue(tokenizer.nextToken());
        cordLength = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speakers speakers = (Speakers) o;
        return Double.compare(speakers.getPowerConsumption(), getPowerConsumption()) == 0 &&
                Double.compare(speakers.getNumberOfSpeakers(), getNumberOfSpeakers()) == 0 &&
                Double.compare(speakers.getCordLength(), getCordLength()) == 0 &&
                getFrequencyRange().equals(speakers.getFrequencyRange());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int)powerConsumption;
        result = 31 * result + (int)numberOfSpeakers;
        result = 31 * result + (int)cordLength;
        result = 31 * result + frequencyRange != null ? frequencyRange.hashCode() : 0;

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Speakers : POWER_CONSUMPTION=").append(powerConsumption).append(", NUMBER_OF_SPEAKERS=");
        builder.append(numberOfSpeakers).append(", FREQUENCY_RANGE=").append(frequencyRange);
        builder.append(", CORD_LENGTH=").append(cordLength);
        return builder.toString();
    }
}
