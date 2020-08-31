package com.buyalskaya.appliance.dao;

import com.buyalskaya.appliance.exception.DaoException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FileNameReader {
    private static final String FILE_PATH = "fileName";
    private String fileName;

    public FileNameReader() throws DaoException {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("property.fileProperties");
            fileName = resourceBundle.getString(FILE_PATH);
        } catch (MissingResourceException ex) {
            throw new DaoException("Properties file is missing", ex);
        }
    }

    public String getFileName() {
        return fileName;
    }
}