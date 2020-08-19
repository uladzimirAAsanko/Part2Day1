package by.sanko.task01.entity;

public class Refrigerator extends Appliance {
    private double powerConsumption;
    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    public Refrigerator(double powerConsumption, double weight, double freezerCapacity, double overallCapacity, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Refrigerator : POWER_CONSUMPTION=").append(powerConsumption).append(", WEIGHT=").append(weight);
        builder.append(", FREEZER_CAPACITY=").append(freezerCapacity).append(", OVERALL_CAPACITY=").append(overallCapacity);
        builder.append(", HEIGHT=").append(height).append(", WIDTH=").append(width);
        return builder.toString();
    }
}
