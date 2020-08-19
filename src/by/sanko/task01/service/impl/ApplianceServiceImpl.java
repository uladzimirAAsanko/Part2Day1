package by.sanko.task01.service.impl;

import by.sanko.task01.dao.ApplianceDAO;
import by.sanko.task01.dao.DAOFactory;
import by.sanko.task01.entity.Appliance;
import by.sanko.task01.entity.criteria.Criteria;
import by.sanko.task01.service.ApplianceService;
import by.sanko.task01.service.validation.Validator;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public Appliance find(Criteria criteria) {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        Appliance appliance = applianceDAO.find(criteria);

        // you may add your own code here

        return appliance;
    }

}
