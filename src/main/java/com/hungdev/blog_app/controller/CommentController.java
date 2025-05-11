package com.hungdev.blog_app.controller;

import com.hungdev.blog_app.dto.CommentDto;
import com.hungdev.blog_app.form.CommentCreateForm;
import com.hungdev.blog_app.form.CommentFilterForm;
import com.hungdev.blog_app.form.CommentUpdateForm;
import com.hungdev.blog_app.service.CommentService;
import com.hungdev.blog_app.validation.CommentIdExists;
import com.hungdev.blog_app.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("api/v1/comments")
    public Page<CommentDto> findAll(CommentFilterForm commentFilterForm, Pageable pageable){
        return commentService.findAll(commentFilterForm ,pageable);
    }

    @GetMapping("api/v1/posts/{postId}/comments")
    public Page<CommentDto> findByPostId(@PathVariable("postId") @PostIdExists Long postId, Pageable pageable) {
        return commentService.findByPostId(postId, pageable);
    }

    @GetMapping("api/v1/comments/{id}")
    public CommentDto findById(@PathVariable("id") @CommentIdExists Long id){
        return commentService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("api/v1/posts/{postId}/comments")
    public CommentDto create(@PathVariable @PostIdExists Long postId, @RequestBody @Valid CommentCreateForm form){
        return commentService.create(form, postId);
    }

    @PutMapping("api/v1/comments/{id}")
    public CommentDto update(
            @RequestBody @Valid CommentUpdateForm form,
            @PathVariable("id") @CommentIdExists Long id
    ){
        return commentService.update(form, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") @CommentIdExists Long id){
        commentService.deleteById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("api/v1/posts/{postId}/comments")
    public void deleteAllByPostId(@PathVariable("postId") @PostIdExists Long postId) {
        commentService.deleteAllByPostId(postId);
    }

}
