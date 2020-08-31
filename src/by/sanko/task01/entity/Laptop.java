package by.sanko.task01.entity;

import java.util.Objects;
import java.util.StringTokenizer;

public class Laptop extends Appliance {
    private int batteryCapacity;
    private String OS;
    private long memoryROM;
    private long systemMemory;
    private double CPU;
    private int displayINCH;

    public Laptop(int batteryCapacity, String OS, long memoryROM, long systemMemory, double CPU, int displayINCH) {
        this.batteryCapacity = batteryCapacity;
        this.OS = OS;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.CPU = CPU;
        this.displayINCH = displayINCH;
    }

    public Laptop(String input){
        StringTokenizer tokenizer = new StringTokenizer(input);
        tokenizer.nextToken();
        tokenizer.nextToken();
        batteryCapacity = Integer.parseInt(Appliance.parseValue(tokenizer.nextToken()));
        OS = Appliance.parseValue(tokenizer.nextToken());
        memoryROM = Long.parseLong(parseValue(tokenizer.nextToken()));
        systemMemory = Long.parseLong(parseValue(tokenizer.nextToken()));
        CPU = Double.parseDouble(parseValue(tokenizer.nextToken()));
        displayINCH = Integer.parseInt(Appliance.parseValue(tokenizer.nextToken()));
    }


    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getOS() {
        return OS;
    }

    public long getMemoryROM() {
        return memoryROM;
    }

    public long getSystemMemory() {
        return systemMemory;
    }

    public double getCPU() {
        return CPU;
    }

    public int getDisplayINCH() {
        return displayINCH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return getBatteryCapacity() == laptop.getBatteryCapacity() &&
                getMemoryROM() == laptop.getMemoryROM() &&
                getSystemMemory() == laptop.getSystemMemory() &&
                Double.compare(laptop.getCPU(), getCPU()) == 0 &&
                getDisplayINCH() == laptop.getDisplayINCH() &&
                getOS().equals(laptop.getOS());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (int)batteryCapacity;
        result = 31 * result + OS != null ? OS.hashCode() : 0;
        result = (int) (31 * result + memoryROM);
        result = (int) (31 * result + systemMemory);
        result = 31 * result + (int)CPU;
        result = 31 * result + displayINCH;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Laptop : BATTERY_CAPACITY=").append(batteryCapacity).append(", OS=").append(OS);
        builder.append(", MEMORY_ROM=").append(memoryROM).append(", SYSTEM_MEMORY=").append(systemMemory);
        builder.append(", CPU=").append(CPU).append(", DISPLAY_INCHS=").append(displayINCH);
        return builder.toString();
    }
}
