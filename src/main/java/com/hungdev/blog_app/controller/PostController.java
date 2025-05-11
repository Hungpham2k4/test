package com.hungdev.blog_app.controller;

import com.hungdev.blog_app.dto.PostDto;
import com.hungdev.blog_app.form.PostCreateForm;
import com.hungdev.blog_app.form.PostFilterForm;
import com.hungdev.blog_app.form.PostUpdateForm;
import com.hungdev.blog_app.service.PostService;
import com.hungdev.blog_app.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("api/v1/posts")
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable) {
        return postService.findAll(form, pageable);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") @PostIdExists Long id){
        return postService.findById(id);
    }

    @PostMapping("api/v1/posts")
    public PostDto create(@RequestBody @Valid PostCreateForm form){
        return postService.create(form);
    }

    @PutMapping("api/v1/posts/{id}")
    public PostDto update(
           @RequestBody PostUpdateForm form,
           @PathVariable("id") @PostIdExists Long id
    ){
        return postService.update(form, id);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") @PostIdExists Long id){
        postService.deleteById(id);
    }
}
