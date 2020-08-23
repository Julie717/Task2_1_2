package com.buyalskaya.appliance.service.validation;

import com.buyalskaya.appliance.entity.ApplianceType;
import com.buyalskaya.appliance.entity.criteria.Criteria;

import java.util.Arrays;
import java.util.Map;

public class CriteriaValidator {

    public static boolean criteriaValidator(Criteria criteria) {
        String groupSearchName = criteria.getGroupSearchName();
        boolean isValid = groupSearchNameValidator(groupSearchName);
        if (isValid) {
            Map<String, String> criteriaParameters = criteria.getCriteria();
            boolean isParameterValid;
            for (Map.Entry criteriaParameter : criteriaParameters.entrySet()) {
                isParameterValid = searchCriteriaValidator(groupSearchName,
                        criteriaParameter.getKey().toString(), criteriaParameter.getValue().toString());
                if (!isParameterValid) {
                    return false;
                }
            }
        }
        return isValid;
    }

    private static boolean groupSearchNameValidator(String groupSearchName) {
        boolean isValid = false;
        if (groupSearchName != null && !groupSearchName.isEmpty()) {
            isValid = Arrays.stream(ApplianceType.values())
                    .anyMatch(o -> o.name().equals(groupSearchName.toUpperCase()));
        }
        return isValid;
    }

    private static boolean searchCriteriaValidator(String groupSearchName, String attributeName, String attributeValue) {
        boolean isValid = Arrays.stream(ApplianceType.valueOf(groupSearchName.toUpperCase()).getParameter())
                .anyMatch(o -> o.name().equals(attributeName.toUpperCase()));
        if (isValid) {
            isValid = ApplianceType.valueOf(groupSearchName.toUpperCase()).test(attributeName, attributeValue);
        }
        return isValid;
    }
}