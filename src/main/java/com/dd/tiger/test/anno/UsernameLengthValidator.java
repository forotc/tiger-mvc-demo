package com.dd.tiger.test.anno;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * User Validator：
 * Implement javax.validation.ConstraintValidator interface for define specified valid rules.
 * This demo shows how to valid length of username.
 */
public class UsernameLengthValidator implements ConstraintValidator<UsernameLength, String> {
    public static final int MAX_LENGTH = 20;
    public static final int MIN_LENGTH = 1;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value) && value.length() >= MIN_LENGTH && value.length() <= MAX_LENGTH;
    }
}