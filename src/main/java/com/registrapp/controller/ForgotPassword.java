package com.registrapp.controller;

import com.registrapp.mail.ForgetMail;
import com.registrapp.models.User;
import com.registrapp.service.UserFileService;
import com.registrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ForgotPassword {

    @Autowired
    UserService userService;

    @Autowired
    UserFileService userFileService;

    @Autowired
    private ForgetMail forgetMail;

    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public ModelAndView forgetPasswordGet(@ModelAttribute("id") @RequestParam("id") Integer id, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        model.addObject("id", id);

        model.setViewName("content-forget-password");

        return model;

    }

    @RequestMapping(value = "/forgetNewPassword", method = RequestMethod.POST)
    public ModelAndView forgetPasswordSuccess(@RequestParam("id") Integer id,@ModelAttribute("password") String password, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        User users = userService.getUserById(id);

        users.setPassword(password);

        userService.saveOrUpdate(users);

        model.setViewName("content-forget-password-success");

        return model;

    }

    @RequestMapping(value = "/sendforgetpassword", method = RequestMethod.POST)
    public String forgetPasswordSend(@ModelAttribute("email") String email, ModelMap modelMap, HttpServletRequest request) throws MessagingException {

        modelMap.addAttribute("email", email);


        List<User> users = userService.getAllUser();

        for(User item : users){
            if(email.equals(item.getEmail())){
                forgetMail.sendForgetEmail(email, item.getId());
                return "content-forget-password-send";
            }}

        modelMap.addAttribute("noUser", "Такого юзера нет");

        return "forgot.password";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public ModelAndView forgotPassword() {

        ModelAndView model = new ModelAndView();

        model.setViewName("forgot.password");

        return model;

    }
}