package org.example.functionalinterface.combinator.combinatorpatternbyme.enum_;


public enum CustomerValidationResult implements ValidationResult{
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT;


    @Override
    public Boolean isSuccess() {
        return Boolean.FALSE;
    }
}
