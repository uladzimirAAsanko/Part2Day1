package by.sanko.task01.entity;

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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VacuumCleaner : POWER_CONSUMPTION=").append(powerConsumption).append(", FILTER_TYPE=");
        builder.append(filterType).append(", BAG_TYPE=").append(bagType).append(", WAND_TYPE=").append(wandType);
        builder.append(", MOTOR_SPEED_REGULATION=").append(motorSpeedRegulation).append(", CLEANING_WIDTH=").append(cleaningWidth);
        return builder.toString();
    }
}
