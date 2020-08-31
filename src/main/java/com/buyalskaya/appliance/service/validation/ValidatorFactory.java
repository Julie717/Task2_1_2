package com.buyalskaya.appliance.service.validation;

public class ValidatorFactory {
    private static final ValidatorFactory instance = new ValidatorFactory();

    private final ValueValidator valueValidator = new ValueValidator();
    private final CriteriaValidator criteriaValidator = new CriteriaValidator();

    private ValidatorFactory() {
    }

    public ValueValidator getValueValidator() {
        return valueValidator;
    }

    public CriteriaValidator getCriteriaValidator() {
        return criteriaValidator;
    }

    public static ValidatorFactory getInstance() {
        return instance;
    }
}