package by.sanko.task01.entity;

import java.util.Objects;
import java.util.StringTokenizer;

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

    public Oven(String input){
        StringTokenizer tokenizer = new StringTokenizer(input);
        tokenizer.nextToken();
        tokenizer.nextToken();
        powerConsumption = Double.parseDouble(parseValue(tokenizer.nextToken()));
        weight = Double.parseDouble(parseValue(tokenizer.nextToken()));
        capacity = Double.parseDouble(parseValue(tokenizer.nextToken()));
        depth = Double.parseDouble(parseValue(tokenizer.nextToken()));
        height = Double.parseDouble(parseValue(tokenizer.nextToken()));
        width = Double.parseDouble(parseValue(tokenizer.nextToken()));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oven oven = (Oven) o;
        return Double.compare(oven.getPowerConsumption(), getPowerConsumption()) == 0 &&
                Double.compare(oven.getWeight(), getWeight()) == 0 &&
                Double.compare(oven.getCapacity(), getCapacity()) == 0 &&
                Double.compare(oven.getDepth(), getDepth()) == 0 &&
                Double.compare(oven.getHeight(), getHeight()) == 0 &&
                Double.compare(oven.getWidth(), getWidth()) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int)powerConsumption;
        result = (int) (31 * result + weight);
        result = (int) (31 * result + capacity);
        result = (int) (31 * result + depth);
        result = 31 * result + (int)height;
        return result;
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
