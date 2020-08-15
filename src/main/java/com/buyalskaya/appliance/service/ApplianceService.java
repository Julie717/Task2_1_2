package com.buyalskaya.appliance.service;

import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.List;

public interface ApplianceService {
	List<Appliance> find(Criteria criteria)throws ServiceException;
}