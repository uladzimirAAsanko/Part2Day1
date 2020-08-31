package by.sanko.task01.service.impl;

import by.sanko.task01.dao.ApplianceDAO;
import by.sanko.task01.dao.DAOFactory;
import by.sanko.task01.entity.Appliance;
import by.sanko.task01.entity.criteria.Criteria;
import by.sanko.task01.exception.DAOException;
import by.sanko.task01.exception.ServiceException;
import by.sanko.task01.service.ApplianceService;
import by.sanko.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;


public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> find(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            throw new ServiceException("Validation Error");
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        List<Appliance> appliance = null;
        try {
            appliance = applianceDAO.find(criteria);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return appliance;
    }

}
