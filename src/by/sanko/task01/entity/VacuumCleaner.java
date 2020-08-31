package by.sanko.task01.entity;

import java.util.Objects;
import java.util.StringTokenizer;

public class VacuumCleaner extends Appliance {
    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private double cleaningWidth;

    public VacuumCleaner(double powerConsumption, String filterType, String bagType, String wandType, int motorSpeedRegulation, double cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public VacuumCleaner(String input){
        StringTokenizer tokenizer = new StringTokenizer(input);
        tokenizer.nextToken();
        tokenizer.nextToken();
        powerConsumption = Double.parseDouble(parseValue(tokenizer.nextToken()));
        filterType = parseValue(tokenizer.nextToken());
        bagType = parseValue(tokenizer.nextToken());
        wandType = parseValue(tokenizer.nextToken());
        motorSpeedRegulation = Integer.parseInt(Appliance.parseValue(tokenizer.nextToken()));
        cleaningWidth = Double.parseDouble(parseValue(tokenizer.nextToken()));
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public int getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return Double.compare(that.getPowerConsumption(), getPowerConsumption()) == 0 &&
                getMotorSpeedRegulation() == that.getMotorSpeedRegulation() &&
                Double.compare(that.getCleaningWidth(), getCleaningWidth()) == 0 &&
                getFilterType().equals(that.getFilterType()) &&
                getBagType().equals(that.getBagType()) &&
                getWandType().equals(that.getWandType());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int)powerConsumption;
        result = 31 * result + (int)motorSpeedRegulation;
        result = 31 * result + (int)cleaningWidth;
        result = 31 * result + filterType != null ? filterType.hashCode() : 0;
        result = 31 * result + bagType != null ? bagType.hashCode() : 0;
        result = 31 * result + wandType != null ? wandType.hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VacuumCleaner : POWER_CONSUMPTION=").append(powerConsumption).append(", FILTER_TYPE=");
        builder.append(filterType).append(", BAG_TYPE=").append(bagType).append(", WAND_TYPE=").append(wandType);
        builder.append(", MOTOR_SPEED_REGULATION=").append(motorSpeedRegulation).append(", CLEANING_WIDTH=").append(cleaningWidth);
        return builder.toString();
    }
}
