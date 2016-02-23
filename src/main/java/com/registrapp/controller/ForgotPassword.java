package com.registrapp.controller;

import com.registrapp.mail.ForgetMail;
import com.registrapp.models.User;
import com.registrapp.service.UserFileService;
import com.registrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class ForgotPassword {

    @Autowired
    UserService userService;

    @Autowired
    UserFileService userFileService;

    @Autowired
    private ForgetMail forgetMail;

    @Autowired
    Md5PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/forget", method = RequestMethod.GET)
    public ModelAndView forgetPasswordGet(@ModelAttribute("id") @RequestParam("id") Integer id, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        model.addObject("id", id);

        model.setViewName("content-forget-password");



        return model;

    }

    @RequestMapping(value = "/forgetNewPassword", method = RequestMethod.POST)
    public String forgetPasswordSuccess(@RequestParam("id") Integer id, @ModelAttribute("password") String password, HttpServletRequest request, ModelMap model, BindingResult result) throws NoSuchAlgorithmException {

        User users = userService.getUserById(id);

        if (password.length()<8 || password.equals("")){
            model.addAttribute("id",users.getId());
            model.addAttribute("pass","Incorrect password");
            return "content-forget-password";
        }

        users.setPassword(passwordEncoder.encodePassword(password,""));

        userService.saveOrUpdate(users);


        return "content-forget-password-success";

    }

    @RequestMapping(value = "/sendforgetpassword", method = RequestMethod.POST)
    public String forgetPasswordSend(@ModelAttribute("email") String email, ModelMap modelMap, HttpServletRequest request) throws MessagingException {

        modelMap.addAttribute("email", email);


        List<User> users = userService.getAllUser();

        for(User item : users){
            if(email.toLowerCase().equals(item.getEmail().toLowerCase())){
                forgetMail.sendForgetEmail(email, item.getId());
                return "content-forget-password-send";
            }}

        modelMap.addAttribute("noUser", "This user is not in the database");

        return "forgot.password";
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public ModelAndView forgotPassword() {

        ModelAndView model = new ModelAndView();

        model.setViewName("forgot.password");

        return model;

    }
}
