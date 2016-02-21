package com.registrapp.configuration;


import com.registrapp.dao.UserDao;
import com.registrapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {

    @Autowired
    UserDao userDao;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
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
        if (!form.getEmail().matches(EMAIL_PATTERN) || form.getEmail().equals(""))
            errors.rejectValue("email", "valid.email", "Email is required.");
        if (userDao.getUserByEmail(form.getEmail()) != null)
            errors.rejectValue("email", "valid.duplicatedEmail", "Email is required.");
        if (form.getPassword().length() < 8 || form.getPassword().equals(""))
            errors.rejectValue("password", "valid.password.length", "Incorrect password");
    }
}
