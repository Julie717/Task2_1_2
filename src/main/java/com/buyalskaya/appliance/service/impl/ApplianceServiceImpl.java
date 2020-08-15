package com.buyalskaya.appliance.service.impl;

import com.buyalskaya.appliance.creator.ApplianceCreator;
import com.buyalskaya.appliance.dao.ApplianceDAO;
import com.buyalskaya.appliance.dao.DAOFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.exception.DaoException;
import com.buyalskaya.appliance.exception.ServiceException;
import com.buyalskaya.appliance.parser.DataParser;
import com.buyalskaya.appliance.service.ApplianceService;
import com.buyalskaya.appliance.service.validation.CriteriaValidator;
import com.buyalskaya.appliance.service.validation.DataValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> find(Criteria criteria) throws ServiceException {
        if (!CriteriaValidator.criteriaValidator(criteria)) {
            throw new ServiceException("Incorrect criteria");
        }
        List<Appliance> appliances = new ArrayList<>();
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();
        try {
            List<String> appliancesString = applianceDAO.find(criteria);
            if(appliancesString.isEmpty()){
                throw new ServiceException("Data isn't found");
            }
            if (!DataValidator.isStringApplianceValid(appliancesString)) {
                throw new ServiceException("Incorrect data in file");
            }
            DataParser dataParser = new DataParser();
            ApplianceCreator applianceCreator = new ApplianceCreator();
            String applianceType;
            Map<String, String> parameters;
            for (String appliance : appliancesString) {
                applianceType = dataParser.applianceTypeParse(appliance);
                parameters = dataParser.applianceParametersParse(appliance);
                Appliance a=applianceCreator.createAppliance(applianceType,parameters);
                appliances.add(a);
            }
        } catch (DaoException ex) {
            throw new ServiceException("DaoException was found: ", ex);
        }
        return appliances;
    }
}