package org.example.functionalinterface.combinator.combinatorpatternbyme;

import org.example.functionalinterface.combinator.combinatorpatternbyme.enum_.ValidationResult;
import org.example.functionalinterface.combinator.combinatorpatternbyme.model.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class TestEntry {

    @Test
    @DisplayName("Use case")
    void test(){
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                LocalDate.of(2000, 1, 1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = CustomerValidator.isEmailValid()
                .and(CustomerValidator.isPhoneNumberValid())
                .and(CustomerValidator.isAnAdult())
                .apply(customer);

        System.out.println(result);

        if(!result.isSuccess()){
            throw new IllegalStateException(result.name());
        }
    }
}
