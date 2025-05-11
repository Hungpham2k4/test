package com.hungdev.blog_app.mapper;

import com.hungdev.blog_app.dto.CommentDto;
import com.hungdev.blog_app.entity.Comment;
import com.hungdev.blog_app.form.CommentCreateForm;
import com.hungdev.blog_app.form.CommentUpdateForm;

public class CommentMapper {
    public static CommentDto map(Comment comment) {
        var dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }

    public static Comment map(CommentCreateForm form) {
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }

    public static void map(CommentUpdateForm form, Comment comment) {
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
    }
}
