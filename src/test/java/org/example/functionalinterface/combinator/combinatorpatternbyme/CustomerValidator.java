package org.example.functionalinterface.combinator.combinatorpatternbyme;

import org.example.functionalinterface.combinator.combinatorpatternbyme.enum_.BasicValidationResult;
import org.example.functionalinterface.combinator.combinatorpatternbyme.enum_.CustomerValidationResult;
import org.example.functionalinterface.combinator.combinatorpatternbyme.model.Customer;

import java.time.LocalDate;
import java.time.Period;


public interface CustomerValidator extends Validator<Customer>{

    static CustomerValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                BasicValidationResult.SUCCESS : CustomerValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                BasicValidationResult.SUCCESS : CustomerValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerValidator isAnAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                BasicValidationResult.SUCCESS : CustomerValidationResult.IS_NOT_AN_ADULT;
    }
}
