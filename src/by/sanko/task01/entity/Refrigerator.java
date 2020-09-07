package by.sanko.task01.entity;

import by.sanko.task01.service.parser.DataParser;

import java.util.StringTokenizer;

public class Refrigerator implements Appliance {
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

    public Refrigerator(String input){
        StringTokenizer tokenizer = new StringTokenizer(input);
        tokenizer.nextToken();
        tokenizer.nextToken();
        DataParser parser = DataParser.getInstance();
        powerConsumption = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
        weight = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
        freezerCapacity = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
        overallCapacity = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
        height = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
        width = Double.parseDouble(parser.parseValue(tokenizer.nextToken()));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return Double.compare(that.getPowerConsumption(), getPowerConsumption()) == 0 &&
                Double.compare(that.getWeight(), getWeight()) == 0 &&
                Double.compare(that.getFreezerCapacity(), getFreezerCapacity()) == 0 &&
                Double.compare(that.getOverallCapacity(), getOverallCapacity()) == 0 &&
                Double.compare(that.getHeight(), getHeight()) == 0 &&
                Double.compare(that.getWidth(), getWidth()) == 0;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int)powerConsumption;
        result = (int) (31 * result + weight);
        result = (int) (31 * result + freezerCapacity);
        result = (int) (31 * result + overallCapacity);
        result = 31 * result + (int)height;
        result = 31 * result + (int)width;
        return result;
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
