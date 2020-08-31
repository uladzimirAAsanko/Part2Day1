package by.sanko.task01.main;


import by.sanko.task01.entity.criteria.Criteria;
import by.sanko.task01.entity.criteria.SearchCriteria;
import by.sanko.task01.service.ApplianceService;
import by.sanko.task01.service.ServiceFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService applianceService = factory.getApplianceService();
        String answer = "";
        System.out.println("Please choose the type of Appliance that you want to find. If you want to exit type q");
        while(!answer.equals("q")) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                for(int i = 0; i < TYPES.values().length; i++){
                    System.out.println(TYPES.values()[i] +" - "+ i);
                }
                answer = reader.readLine();
                if(answer.equals("q")){
                    break;
                }
                Criteria criteria = new Criteria(TYPES.values()[Integer.parseInt(answer)].toString());
                System.out.println("If you want to add some criterias please type + ");
                answer = reader.readLine();
                while(answer.equals("+")){
                    String name = "";
                    String data = "";
                    System.out.println("Please type option you want to add");
                    name = reader.readLine();
                    System.out.println("Please type data you want to find");
                    data = reader.readLine();
                    criteria.add(name,data);
                    System.out.println("If you want to add some criterias please type + ");
                    answer = reader.readLine();
                }
                System.out.println("Here you can see results of search");
                applianceService.find(criteria).forEach(appliance -> System.out.println(appliance.toString()));
                System.out.println("Please choose the type of Appliance that you want to find. If you want to exit type q");
                answer = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("GoodBuy!");
    }

    public static enum TYPES{
        Laptop, Oven, Refrigerator, Speakers, TabletPC, VacuumCleaner;

    }
}
