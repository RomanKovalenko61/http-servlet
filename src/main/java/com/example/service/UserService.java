package com.example.service;

import com.example.dao.UserDao;
import com.example.dto.CreateUserDto;
import com.example.dto.UserDTO;
import com.example.exception.ValidationException;
import com.example.mapper.CreateUserMapper;
import com.example.mapper.UserMapper;
import com.example.validator.CreateUserValidator;
import lombok.SneakyThrows;

import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private static final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private static final UserDao userDao = UserDao.getInstance();
    private static final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private static final ImageService imageService = ImageService.getInstance();
    private static final UserMapper userMapper = UserMapper.getInstance();

    private UserService() {
    }

    public Optional<UserDTO> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}