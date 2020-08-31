package by.sanko.task01.dao;

import by.sanko.task01.entity.Appliance;
import by.sanko.task01.entity.criteria.Criteria;
import by.sanko.task01.exception.DAOException;

import java.util.List;

public interface ApplianceDAO {
    List<Appliance> find(Criteria criteria) throws DAOException;
}