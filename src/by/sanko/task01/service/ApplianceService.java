package by.sanko.task01.service;

import by.sanko.task01.entity.Appliance;
import by.sanko.task01.entity.criteria.Criteria;
import by.sanko.task01.exception.ServiceException;

import java.util.List;

public interface ApplianceService {

    List<Appliance> find(Criteria criteria) throws ServiceException;

}