package com.hungdev.blog_app.validation;

import com.hungdev.blog_app.repository.CommentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentIdExistsValidator implements ConstraintValidator<CommentIdExists, Long> {
    private CommentRepository commentRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return commentRepository.existsById(id);
    }
}
