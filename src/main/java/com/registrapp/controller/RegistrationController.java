package com.registrapp.controller;

import com.registrapp.configuration.RegistrationValidator;
import com.registrapp.mail.RegistrationMail;
import com.registrapp.models.User;
import com.registrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationMail registrationMail;

    @Autowired
    @Qualifier("registrationValidator")
    private RegistrationValidator registrationValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(User user, ModelMap model) {
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("RegistrationForm")User user, BindingResult result, ModelMap model) throws MessagingException {
        registrationValidator.validate(user, result);
        if (result.hasErrors()){
            model.addAttribute("user", user);
            return "registration";
        }
        userService.addUser(user);
        User users = userService.getUserByEmail(user.getEmail());
        registrationMail.sendRegistrationEmail(users.getEmail(), users.getId());
        return "registration-success";
    }
}
