package by.sanko.task01.entity;

public class Speakers extends Appliance {
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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Speakers : POWER_CONSUMPTION=").append(powerConsumption).append(", NUMBER_OF_SPEAKERS=");
        builder.append(numberOfSpeakers).append(", FREQUENCY_RANGE=").append(frequencyRange);
        builder.append(", CORD_LENGTH=").append(cordLength);
        return builder.toString();
    }
}
