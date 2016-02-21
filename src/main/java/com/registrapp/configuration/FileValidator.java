package com.registrapp.configuration;

import com.registrapp.models.File;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return File.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        File file = (File) obj;

        if(file.getFile()!=null){
            if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }else{
        if (file.getDescription().length() < 10 || file.getDescription().length() > 200 || file.getDescription().equals(""))
        {errors.rejectValue("description", "valid.password.length", "Incorrect password");}
        else{
        if (file.getName().length() > 25 || file.getName().equals(""))
            errors.rejectValue("name", "valid.password.length", "Incorrect password");}
        }
    }
}