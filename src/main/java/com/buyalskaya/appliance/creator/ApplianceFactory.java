package com.buyalskaya.appliance.creator;

import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.exception.ServiceException;

import java.util.Map;

public interface ApplianceFactory {
    Appliance createAppliance(Map<String,String> parameters)throws ServiceException;
}