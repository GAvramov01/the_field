//package com.example.airsoft_web.util;
//
//import org.apache.el.util.Validation;
//import org.springframework.stereotype.Component;
//
//import javax.validation.Validator;
//
//@Component
//public class ValidationUtilImpl implements ValidationUtil {
//
//    private final Validator validator;
//
//    public ValidationUtilImpl() {
//        validator = Validation
//                .buildDefaultValidatorFactory()
//                .getValidator();
//    }
//
//    @Override
//    public <E> boolean isValid(E entity) {
//        return validator.validate(entity).isEmpty();
//    }
//}
