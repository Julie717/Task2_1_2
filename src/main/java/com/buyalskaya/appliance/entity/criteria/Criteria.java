package com.buyalskaya.appliance.entity.criteria;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Criteria {
    private String groupSearchName;
    private Map<String, String> criteria = new HashMap();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, String value) {
        criteria.put(searchCriteria, value);
    }

    public void remove(String searchCriteria, String value) {
        criteria.remove(searchCriteria, value);
    }

    public Map<String, String> getCriteria() {
        return Collections.unmodifiableMap(criteria);
    }
}