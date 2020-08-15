package com.buyalskaya.appliance.service.validation;

import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.entity.criteria.SearchCriteria;

import java.util.stream.Stream;

public class CriteriaValidator {
    public static boolean criteriaValidator(Criteria criteria) {
        String groupSearchName = criteria.getGroupSearchName();
        boolean isValid = groupSearchNameValidator(groupSearchName);
        if (isValid) {
           /* Class applianceClass=Stream.of(SearchCriteria.class.getDeclaredClasses())
                    .filter(c->c.getSimpleName().toUpperCase().equals(groupSearchName.toUpperCase()))
                    .findAny().get();*/
            isValid =  Stream.of(criteria.getCriteria().keySet().toArray())
                    .allMatch(c -> searchCriteriaValidator(groupSearchName, c.toString()));
         //   SearchCriteria.Oven.CAPACITY.getClass().getDeclaredMethod("test",5)
         /*  Stream.of(SearchCriteria.class.getDeclaredClasses())
                    .filter(s -> s.getSimpleName().toUpperCase().equals(groupSearchName.toUpperCase()))
                    .flatMap(s -> Stream.of(s.getDeclaredFields()))
                    .filter(s -> s.getName().toUpperCase().equals(searchCriteria.toUpperCase()))
                    .forEach(s->s.getClass().getDeclaredMethod("test",criteria.getCriteria().values()));*/
        }

        return isValid;
    }

    public static boolean groupSearchNameValidator(String groupSearchName) {
        boolean isValid = false;
        if (groupSearchName != null) {
            isValid = Stream.of(SearchCriteria.class.getDeclaredClasses())
                    .anyMatch(s -> s.getSimpleName().toUpperCase().equals(groupSearchName.toUpperCase()));
        }
        return isValid;
    }

    public static boolean searchCriteriaValidator(String groupSearchName, String searchCriteria) {
        boolean isValid = false;
        if (searchCriteria != null) {
            isValid = Stream.of(SearchCriteria.class.getDeclaredClasses())
                    .filter(s -> s.getSimpleName().toUpperCase().equals(groupSearchName.toUpperCase()))
                    .flatMap(s -> Stream.of(s.getDeclaredFields()))
                    .anyMatch(s -> s.getName().toUpperCase().equals(searchCriteria.toUpperCase()));
        }
        return isValid;
    }
}