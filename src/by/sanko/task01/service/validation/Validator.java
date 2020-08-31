package by.sanko.task01.service.validation;

import by.sanko.task01.entity.criteria.Criteria;
import by.sanko.task01.entity.criteria.SearchCriteria;

public class Validator {
    public static boolean criteriaValidator(Criteria criteria) {
        try {
            switch (criteria.getGroupSearchName()){

                case "Oven":
                    criteria.getCriteria().forEach((name, obj) -> {
                        SearchCriteria.Oven.valueOf(name);
                    });
                    break;
                case "Laptop":
                    criteria.getCriteria().forEach((name, obj) -> {
                        SearchCriteria.Laptop.valueOf(name);
                    });
                    break;
                case "Refrigerator":
                    criteria.getCriteria().forEach((name, obj) -> {
                        SearchCriteria.Refrigerator.valueOf(name);
                    });
                    break;
                case "Speakers":
                    criteria.getCriteria().forEach((name, obj) -> {
                        SearchCriteria.Speakers.valueOf(name);
                    });
                    break;
                case "TabletPC":
                    criteria.getCriteria().forEach((name, obj) -> {
                        SearchCriteria.TabletPC.valueOf(name);
                    });
                    break;
                case "VacuumCleaner":
                    criteria.getCriteria().forEach((name, obj) -> {
                        SearchCriteria.VacuumCleaner.valueOf(name);
                    });
                    break;
            }
        }catch (IllegalArgumentException | NullPointerException exception){
            return false;
        }

        return true;
    }
}
