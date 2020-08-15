package com.buyalskaya.appliance.main;

import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;
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

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(SearchCriteria.Oven.CAPACITY.toString(), "3");
        try {
            appliances = service.find(criteriaOven);

            PrintApplianceInfo.print(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), "200");
        criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), "300");
        try {
            appliances = service.find(criteriaOven);

            PrintApplianceInfo.print(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPc.class.getSimpleName());
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), "14");
        criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), "8000");
        try {
            appliances = service.find(criteriaTabletPC);// find(Object...obj)
            PrintApplianceInfo.print(appliances);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
