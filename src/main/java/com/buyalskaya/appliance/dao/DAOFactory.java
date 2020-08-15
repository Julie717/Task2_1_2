package com.buyalskaya.appliance.dao;

import com.buyalskaya.appliance.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

    private DAOFactory() {
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}