package com.registrapp.controller;

import com.registrapp.configuration.EditProfileValidator;
import com.registrapp.configuration.RegistrationValidator;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            model.addObject("logout", "Вы успешно вышли с аккаунта");
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
            error = "Не правильное имя или пароль";
        } else if (exception instanceof LockedException) {
            error = "Вы не активировали свой аккаунт";
        } else if (exception instanceof DisabledException){
            error = "Ваш пользователь заблокирован";
        } else {
            error = "Не правильное имя или пароль";
        }
        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        // check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;
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
    public ModelAndView verifyEmail(@RequestParam("id") Integer id, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();

        model.addObject("verification", "Вы успешно активировали свой аккаунт");

        User user = userService.getUserById(id);

        user.setAccount_status("enabled");

        userService.saveOrUpdate(user);

        model.setViewName("content-login");

        return model;

    }

    @RequestMapping(value = "/myfiles", method = RequestMethod.GET)
    public String Myfiles(ModelMap model) {

        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(user);

        model.addAttribute("currentUser", currentUser);

        List<UserFile> files = userFileService.findAllByUserId(currentUser.getId());
        model.addAttribute("files", files);

        return "user.my.files";

    }

    @RequestMapping(value = { "/download-file-{fileId}" }, method = RequestMethod.GET)
    @ResponseBody
    public String downloadDocument(@PathVariable("fileId") int fileId, HttpServletResponse response) throws IOException {
        UserFile file = userFileService.findById(fileId);
        response.setContentType(file.getType());
        response.setContentLength(file.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + file.getNameFile() +"\"");

        FileCopyUtils.copy(file.getContent(), response.getOutputStream());

        return "redirect:/myfiles";
    }

    @RequestMapping(value = { "/delete-file-{fileId}" }, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int fileId) {
        userFileService.deleteById(fileId);
        return "redirect:/myfiles";
    }

    @RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
    public String editProfile(ModelMap model) {

        String userContext = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userService.getUserByEmail(userContext);

        model.addAttribute("user", user);

        String userEdit = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(userEdit);

        model.addAttribute("currentUser", currentUser);

        return "user.edit.profile";
    }

    @RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
    public String editProfile1(@ModelAttribute("user")User user, ModelMap model, BindingResult result) {

        editProfileValidator.validate(user, result);

        String userEdit = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(userEdit);

        model.addAttribute("currentUser", currentUser);

        if (result.hasErrors())
            return "user.edit.profile";

        userService.saveOrUpdate(user);

        model.addAttribute("editSuccess","success.edit.profile");

        return "user.edit.profile";
    }



}
