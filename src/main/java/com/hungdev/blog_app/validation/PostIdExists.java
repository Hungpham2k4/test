package com.hungdev.blog_app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(
        validatedBy = {PostIdExistsValidator.class}
)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostIdExists {
    String message() default "Id bài viết không tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
