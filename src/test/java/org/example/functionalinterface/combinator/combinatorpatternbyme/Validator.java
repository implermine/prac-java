package org.example.functionalinterface.combinator.combinatorpatternbyme;

import org.example.functionalinterface.combinator.combinatorpatternbyme.enum_.BasicValidationResult;
import org.example.functionalinterface.combinator.combinatorpatternbyme.enum_.ValidationResult;

import java.util.Objects;
import java.util.function.Function;

public interface Validator <IN> extends Function<IN, ValidationResult> {

    default Validator<IN> and(Validator<IN> after){
        Objects.requireNonNull(after);

        return what -> {
            ValidationResult result = apply(what);
            return result.equals(BasicValidationResult.SUCCESS) ? after.apply(what) : result;
        };
    }


}
