package com.example.service;

import com.example.dao.UserDao;
import com.example.dto.CreateUserDto;
import com.example.exception.ValidationException;
import com.example.mapper.CreateUserMapper;
import com.example.validator.CreateUserValidator;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    private static final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private static final UserDao userDao = UserDao.getInstance();
    private static final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    private UserService() {
    }

    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}