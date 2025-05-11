package com.hungdev.blog_app.service;

import com.hungdev.blog_app.dto.CommentDto;
import com.hungdev.blog_app.form.CommentCreateForm;
import com.hungdev.blog_app.form.CommentFilterForm;
import com.hungdev.blog_app.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Page<CommentDto> findAll(CommentFilterForm commentFilterForm, Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(Long id);

    CommentDto create(CommentCreateForm form, Long postId);

    CommentDto update(CommentUpdateForm form, Long id);

    void deleteById(Long id);

    void deleteAllByPostId(Long postId);
}
