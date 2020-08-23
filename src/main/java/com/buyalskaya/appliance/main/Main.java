package com.buyalskaya.appliance.main;

import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.entity.impl.Laptop;
import com.buyalskaya.appliance.entity.impl.Oven;
import com.buyalskaya.appliance.entity.impl.TabletPc;
import com.buyalskaya.appliance.exception.ServiceException;
import com.buyalskaya.appliance.service.ApplianceService;
import com.buyalskaya.appliance.service.ServiceFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Appliance> appliances;

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add("DEPTH", "60");
        try {
            appliances = service.find(criteriaOven);
            PrintApplianceInfo.print(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add("HEIGHT", "50");
        criteriaOven.add("DEPTH", "300");
        try {
            appliances = service.find(criteriaOven);
            PrintApplianceInfo.print(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPc.class.getSimpleName());
        criteriaTabletPC.add("COLOR", "BLUE");
        criteriaTabletPC.add("DISPLAY_INCHES", "14");
        criteriaTabletPC.add("MEMORY_ROM", "8000");
        try {
            appliances = service.find(criteriaTabletPC);
            PrintApplianceInfo.print(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
        //////////////////////////////////////////////////////////////////

        Criteria criteriaAllLaptop = new Criteria(Laptop.class.getSimpleName());
        try {
            appliances = service.find(criteriaAllLaptop);
            PrintApplianceInfo.print(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
    }
}