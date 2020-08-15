package com.buyalskaya.appliance.dao;

import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.exception.DaoException;

import java.util.List;

public interface ApplianceDAO {
    List<String> find(Criteria criteria)throws DaoException;
}