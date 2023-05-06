package com.example.validator;

import com.example.dto.CreateUserDto;
import com.example.entity.Gender;
import com.example.entity.Role;
import com.example.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    private CreateUserValidator() {
    }

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        var validationResult = new ValidationResult();
        if (object.getName().isEmpty()) {
            validationResult.add(Error.of("invalid.name", "Name is invalid"));
        }
        //TODO: check email that it is exist or not in database
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if (object.getRole() == null || !Role.isValid(object.getRole())) {
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        if (object.getGender() == null || !Gender.isValid(object.getGender())) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}