package com.buyalskaya.appliance.main;

import com.buyalskaya.appliance.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {

    public static void print(List<Appliance> appliances) {
        if (appliances == null || appliances.isEmpty()) {
            System.out.println("Data isn't found");
        } else {
            for (Appliance appliance : appliances) {
                System.out.println(appliance);
            }
        }
    }
}
