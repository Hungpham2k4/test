package com.hungdev.blog_app.controller;

import com.hungdev.blog_app.dto.UserDto;
import com.hungdev.blog_app.form.UserCreateForm;
import com.hungdev.blog_app.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Validated
public class UserController {
    private UserService userService;

    @PostMapping("api/v1/auth/register")
    public UserDto create(@RequestBody @Valid UserCreateForm userCreateForm) {
        return userService.create(userCreateForm);
    }
}
