package com.registrapp.configuration;

import com.registrapp.dao.UserDao;
import com.registrapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EditProfileValidator implements Validator {

    @Autowired
    UserDao userDao;

    private static final String FIO_PATTERN = "[\\p{InCyrillic}|']+";

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User form = (User) target;

        if (!form.getFirstname().matches(FIO_PATTERN) || form.getFirstname().equals("") || form.getFirstname().length() > 12)
            errors.rejectValue("firstname", "valid.firstName", "FirstName is required.");
        if (!form.getLastname().matches(FIO_PATTERN) || form.getLastname().equals("") || form.getLastname().length() > 12)
            errors.rejectValue("lastname", "valid.lastName", "LastName is required.");
        if (form.getPassword().length() < 8 || form.getPassword().equals(""))
            errors.rejectValue("password", "valid.password.length", "Incorrect password");
    }
}

