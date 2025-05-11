package com.hungdev.blog_app.service;

import com.hungdev.blog_app.dto.UserDto;
import com.hungdev.blog_app.form.UserCreateForm;

public interface UserService {
    UserDto create(UserCreateForm userCreateForm);
}
