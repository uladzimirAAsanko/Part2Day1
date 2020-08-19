package by.sanko.task01.entity;

public class TabletPC extends Appliance {
    private double batteryCapacity;
    private double displayInches;
    private long memoryROM;
    private int flashMemoryCapacity;
    private String color;

    public TabletPC(double batteryCapacity, double displayInches, long memoryROM, int flashMemoryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public long getMemoryROM() {
        return memoryROM;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TabletPC : BATTERY_CAPACITY=").append(batteryCapacity).append(", DISPLAY_INCHES=");
        builder.append(displayInches).append(", MEMORY_ROM=").append(memoryROM).append(", FLASH_MEMORY_CAPACITY=");
        builder.append(flashMemoryCapacity).append(", COLOR=").append(color);
        return builder.toString();
    }
}
