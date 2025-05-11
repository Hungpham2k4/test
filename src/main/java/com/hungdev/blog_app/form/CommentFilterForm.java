package com.hungdev.blog_app.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentFilterForm {
    private String search;
    private Long postId;
}
