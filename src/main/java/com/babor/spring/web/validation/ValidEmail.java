package com.babor.spring.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {com.babor.spring.web.validation.ValidEmailImpl.class})
public @interface ValidEmail {
    String message() default "My Default Validation Message!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int min() default 5;
}