package com.buyalskaya.appliance.dao;

import com.buyalskaya.appliance.exception.DaoException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FilePathReader {
    private static final String FILE_PATH = "filePath";
    private String filePath;

    public FilePathReader() throws DaoException {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("property.fileProperties");
            filePath = resourceBundle.getString(FILE_PATH);
        } catch (MissingResourceException ex) {
            throw new DaoException("Properties file is missing", ex);
        }
    }

    public String getFilePath() {
        return filePath;
    }
}