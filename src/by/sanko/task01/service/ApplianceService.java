package by.sanko.task01.service;

import by.sanko.task01.entity.Appliance;
import by.sanko.task01.entity.criteria.Criteria;

public interface ApplianceService {

    Appliance find(Criteria criteria);

}