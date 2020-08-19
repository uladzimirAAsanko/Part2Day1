package by.sanko.task01.dao;

import by.sanko.task01.entity.Appliance;
import by.sanko.task01.entity.criteria.Criteria;

public interface ApplianceDAO {
    Appliance find(Criteria criteria);
}