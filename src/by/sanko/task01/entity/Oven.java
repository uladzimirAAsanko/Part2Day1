package by.sanko.task01.entity;

public class Oven extends Appliance {
    private double powerConsumption;
    private double weight;
    private double capacity;
    private double depth;
    private double height;
    private double width;

    public Oven(double powerConsumption, double weight, double capacity, double depth, double height, double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getDepth() {
        return depth;
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
        builder.append("Oven : POWER_CONSUMPTION=").append(powerConsumption).append(", WEIGHT=").append(weight);
        builder.append(", CAPACITY=").append(capacity).append(", DEPTH=").append(depth).append(", HEIGHT=");
        builder.append(height).append(", WIDTH=").append(width);
        return builder.toString();
    }
}
