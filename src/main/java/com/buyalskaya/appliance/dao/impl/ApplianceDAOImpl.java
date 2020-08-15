package com.buyalskaya.appliance.dao.impl;

import com.buyalskaya.appliance.dao.ApplianceDAO;
import com.buyalskaya.appliance.dao.FilePathReader;
import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.exception.DaoException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDAOImpl implements ApplianceDAO {
    private final static String EQUALITY = "=";

    @Override
    public List<String> find(Criteria criteria) throws DaoException{
        List<String> appliances;
        FilePathReader filePathReader = new FilePathReader();
        String filePath = filePathReader.getFilePath();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            Stream<String> read = bufferedReader.lines();
            String groupSearchName = criteria.getGroupSearchName();
            if (!groupSearchName.isEmpty()) {
                read = read.filter(a -> a.toUpperCase().contains(groupSearchName.toUpperCase()));
            }
            if (!criteria.getCriteria().isEmpty()) {
                for (Map.Entry<String, String> oneCriteria : criteria.getCriteria().entrySet()) {
                    StringBuilder searchParameter = new StringBuilder(oneCriteria.getKey());
                    searchParameter.append(EQUALITY);
                    searchParameter.append(oneCriteria.getValue());
                    read = read.filter(a -> a.toUpperCase().contains(searchParameter.toString().toUpperCase()));
                }

            }
            appliances = read.collect(Collectors.toList());
        } catch (IOException e) {
            throw new DaoException("Error in opening file " + filePath, e);
        }
        return appliances;
    }
}