package com.buyalskaya.appliance.service.impl;

import com.buyalskaya.appliance.dao.ApplianceDAO;
import com.buyalskaya.appliance.dao.DAOFactory;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.exception.DaoException;
import com.buyalskaya.appliance.exception.ServiceException;
import com.buyalskaya.appliance.service.ApplianceService;
import com.buyalskaya.appliance.service.validation.ValidatorFactory;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    @Override
    public List<Appliance> find(Criteria criteria) throws ServiceException {
        if (!ValidatorFactory.getInstance().getCriteriaValidator().isCriteriaValid(criteria)) {
            throw new ServiceException("Incorrect criteria");
        }
        try {
            ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
            List<Appliance> appliances = applianceDAO.find(criteria);
            return appliances;
        } catch (DaoException ex) {
            throw new ServiceException("DaoException was found: ", ex);
        }
    }
}