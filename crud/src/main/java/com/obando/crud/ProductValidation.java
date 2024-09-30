package com.obando.crud;

import com.obando.crud.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null ,"No debe estar vacio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", null,"No puede estar vacio");
        if(product.getDescription() == null || product.getDescription().isBlank()){
            errors.rejectValue("price", null,"No puede ser nulo y no puede contener espacios en blanco");
        }
    }
}
