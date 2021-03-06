package com.registrapp.controller;

import com.registrapp.configuration.EditProfileValidator;
import com.registrapp.models.User;
import com.registrapp.models.UserFile;
import com.registrapp.service.UserFileService;
import com.registrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserFileService userFileService;

    @Autowired
    Md5PasswordEncoder encoder;




    @Autowired
    @Qualifier("editProfileValidator")
    private EditProfileValidator editProfileValidator;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String defaultWelcomePage(ModelMap model) {

        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(user);

        model.addAttribute("currentUser", currentUser);

        List<UserFile> files = userFileService.findAll();

        model.addAttribute("files", files);

        return "user.all.files";
    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This page is for ROLE_ADMIN only!");

        model.setViewName("admin/admin");

        return model;

    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public ModelAndView indexGet(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request, Authentication authentication) {

        ModelAndView model = new ModelAndView();


        if (logout != null) {
            model.addObject("logout", "You have successfully signed out");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            List<String> roles = new ArrayList<String>();
            for (GrantedAuthority a : authorities) {
                roles.add(a.getAuthority());
            }
            if (roles.contains("ROLE_USER")) {
                return new ModelAndView("redirect:/user");
            } else if (roles.contains("ROLE_ADMIN")) {
                return new ModelAndView("redirect:/admin");
            }
        }

        model.setViewName("base.template");

        return model;

    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Incorrect Username or Password";
        } else if (exception instanceof LockedException) {
            error = "You have not activated your account";
        } else if (exception instanceof DisabledException){
            error = "Your user is locked";
        } else {
            error = "Incorrect Username or Password";
        }
        return error;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage( @RequestParam(value = "error", required = false) String error, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        if (error != null) {
               model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        model.setViewName("content-login");

        return model;

    }



    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public ModelAndView verifyEmail(@RequestParam("id") Integer id, HttpServletRequest request) throws NoSuchAlgorithmException {

        ModelAndView model = new ModelAndView();

        model.addObject("verification", "You have successfully activated your account");

        User user = userService.getUserById(id);

        user.setAccount_status("enabled");

        user.setPassword(user.getPassword());

        userService.saveOrUpdate(user);

        model.setViewName("content-login");

        return model;

    }

    @RequestMapping(value = "/user/myfiles", method = RequestMethod.GET)
    public String Myfiles(ModelMap model) {

        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(user);

        model.addAttribute("currentUser", currentUser);

        List<UserFile> files = userFileService.findAllByUserId(currentUser.getId());
        model.addAttribute("files", files);

        return "user.my.files";

    }

    @RequestMapping(value = {"/user/download-file-{fileId}"}, method = RequestMethod.GET)
    @ResponseBody
    public String downloadDocument(@PathVariable("fileId") int fileId, HttpServletResponse response) throws IOException {
        UserFile file = userFileService.findById(fileId);
        response.setContentType(file.getType());
        response.setContentLength(file.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + file.getNameFile() +"\"");

        FileCopyUtils.copy(file.getContent(), response.getOutputStream());

        return "redirect:/user/myfiles";
    }

    @RequestMapping(value = {"/user/delete-file-{fileId}"}, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int fileId) {
        userFileService.deleteById(fileId);
        return "redirect:/user/myfiles";
    }

    @RequestMapping(value = {"/user/edit-profile"}, method = RequestMethod.GET)
    public String editProfile(ModelMap model) {

        String userContext = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userService.getUserByEmail(userContext);

        model.addAttribute("user", user);

        String userEdit = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(userEdit);

        model.addAttribute("currentUser", currentUser);

        return "user.edit.profile";
    }

    @RequestMapping(value = {"/user/edit-profile"}, method = RequestMethod.POST)
    public String editProfile1(@ModelAttribute("user")User user, ModelMap model, BindingResult result) throws NoSuchAlgorithmException {

        editProfileValidator.validate(user, result);

        String userEdit = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(userEdit);

        model.addAttribute("currentUser", currentUser);

        if (result.hasErrors())
            return "user.edit.profile";

        model.addAttribute("user", user);

        user.setPassword(encoder.encodePassword(user.getPassword(), ""));

        userService.saveOrUpdate(user);

        model.addAttribute("editSuccess", "You have successfully updated your profile");

        return "user.edit.profile";
    }



}
