package org.example.functionalinterface.combinator.combinatorpatternbyme.enum_;

public enum BasicValidationResult implements ValidationResult{
    SUCCESS,
    FAIL;


    @Override
    public Boolean isSuccess() {
        return this.equals(SUCCESS);
    }
}
