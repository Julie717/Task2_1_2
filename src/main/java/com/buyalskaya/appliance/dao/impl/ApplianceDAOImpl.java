package com.buyalskaya.appliance.dao.impl;

import com.buyalskaya.appliance.creator.ApplianceCreator;
import com.buyalskaya.appliance.dao.ApplianceDAO;
import com.buyalskaya.appliance.dao.FileNameReader;
import com.buyalskaya.appliance.entity.Appliance;
import com.buyalskaya.appliance.entity.criteria.Criteria;
import com.buyalskaya.appliance.exception.DaoException;

import javax.naming.Context;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApplianceDAOImpl implements ApplianceDAO {
    private final static String EQUALITY = "=";

    @Override
    public List<Appliance> find(Criteria criteria) throws DaoException {
        List<Appliance> appliances;
        FileNameReader fileNameReader = new FileNameReader();
        String fileName = fileNameReader.getFileName();
        URL url = getClass().getClassLoader().getResource(fileName);
        if (url == null) {
            throw new DaoException("File isn't exist");
        }
        Stream<String> resultStrings = null;
        try {
            Path path = Paths.get(url.toURI());//TODO Used to receive a correct path, because spaces replace to "%20" in a folder name.
            resultStrings = Files.lines(path);
            String groupSearchName = criteria.getGroupSearchName();
            if (!groupSearchName.isEmpty()) {
                resultStrings = resultStrings.filter(a -> a.toUpperCase().contains(groupSearchName.toUpperCase()));
            }
            if (!criteria.getCriteria().isEmpty()) {
                for (Map.Entry<String, String> oneCriteria : criteria.getCriteria().entrySet()) {
                    StringBuilder searchParameter = new StringBuilder(oneCriteria.getKey());
                    searchParameter.append(EQUALITY);
                    searchParameter.append(oneCriteria.getValue());
                    resultStrings = resultStrings.filter(a -> a.toUpperCase().contains(searchParameter.toString().toUpperCase()));
                }
            }
            appliances = resultStrings.map(a -> ApplianceCreator.createAppliance(a)).collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new DaoException("Error in opening file " + fileName, e);
        } finally {
            if (resultStrings != null) {
                resultStrings.close();
            }
        }
        return appliances;
    }
}