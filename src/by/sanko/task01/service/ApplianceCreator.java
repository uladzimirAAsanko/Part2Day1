package by.sanko.task01.service;

import by.sanko.task01.entity.*;

import java.util.StringTokenizer;

public class ApplianceCreator {
    private static ApplianceCreator instance;

    public static ApplianceCreator getInstance() {
        if (instance == null) {
            instance = new ApplianceCreator();
        }
        return instance;
    }

    public Appliance create(String input){
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        Appliance appliance = null;
        switch (tokenizer.nextToken()){
            case "Laptop":
                appliance = new Laptop(input);
                break;
            case "Oven":
                appliance = new Oven(input);
                break;
            case "Refrigerator":
                appliance = new Refrigerator(input);
                break;
            case "Speakers":
                appliance = new Speakers(input);
                break;
            case "TabletPC":
                appliance = new TabletPC(input);
                break;
            case "VacuumCleaner":
                appliance = new VacuumCleaner(input);
                break;
        }
        return appliance;
    }


}
