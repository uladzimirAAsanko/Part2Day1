package by.sanko.task01.entity;

import java.util.Objects;
import java.util.StringTokenizer;

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

    public TabletPC(String input){
        StringTokenizer tokenizer = new StringTokenizer(input);
        tokenizer.nextToken();
        tokenizer.nextToken();
        batteryCapacity = Double.parseDouble(parseValue(tokenizer.nextToken()));
        displayInches = Double.parseDouble(parseValue(tokenizer.nextToken()));
        memoryROM = Long.parseLong(parseValue(tokenizer.nextToken()));
        flashMemoryCapacity = Integer.parseInt(Appliance.parseValue(tokenizer.nextToken()));
        color = parseValue(tokenizer.nextToken());
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return Double.compare(tabletPC.getBatteryCapacity(), getBatteryCapacity()) == 0 &&
                Double.compare(tabletPC.getDisplayInches(), getDisplayInches()) == 0 &&
                getMemoryROM() == tabletPC.getMemoryROM() &&
                getFlashMemoryCapacity() == tabletPC.getFlashMemoryCapacity() &&
                getColor().equals(tabletPC.getColor());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int)batteryCapacity;
        result = 31 * result + (int)displayInches;
        result = 31 * result + (int)memoryROM;
        result = 31 * result + (int)flashMemoryCapacity;
        result = 31 * result + color != null ? color.hashCode() : 0;
        return result;
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
