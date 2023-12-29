package com.bridge.bridge.validator;

import com.bridge.bridge.exceptions.ObjectValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T objectToValidate) {
        Set<ConstraintViolation<T>> violations =  validator.validate(objectToValidate);
        if (!violations.isEmpty()) {
            Set<String> errorMsg = violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect( Collectors.toSet());
            throw new ObjectValidationException (errorMsg, objectToValidate.getClass().getSimpleName());
        }
    }

}