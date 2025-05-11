package com.hungdev.blog_app.service;

import com.hungdev.blog_app.dto.UserDto;
import com.hungdev.blog_app.entity.User;
import com.hungdev.blog_app.form.UserCreateForm;
import com.hungdev.blog_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    @Override
    public UserDto create(UserCreateForm userCreateForm) {
        var user = modelMapper.map(userCreateForm, User.class);
        var encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        var savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameOrEmail(username, username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        var role = user.getRole().name();
        var authorities = AuthorityUtils.createAuthorityList(role);
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                authorities
        );
    }
}
