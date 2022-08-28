package org.example.functionalinterface.combinator.combinatorpatternbyamigo;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static org.example.functionalinterface.combinator.combinatorpatternbyamigo.DeclarativeCustomerValidator.ValidationResult.*;

public interface DeclarativeCustomerValidator
        extends Function<Customer, DeclarativeCustomerValidator.ValidationResult> {

    static DeclarativeCustomerValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static DeclarativeCustomerValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static DeclarativeCustomerValidator isAnAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    default DeclarativeCustomerValidator and (DeclarativeCustomerValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
