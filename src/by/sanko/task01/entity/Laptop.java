package by.sanko.task01.entity;

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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Laptop : BATTERY_CAPACITY=").append(batteryCapacity).append(", OS=").append(OS);
        builder.append(", MEMORY_ROM=").append(memoryROM).append(", SYSTEM_MEMORY=").append(systemMemory);
        builder.append(", CPU=").append(CPU).append(", DISPLAY_INCHS=").append(displayINCH);
        return builder.toString();
    }
}
