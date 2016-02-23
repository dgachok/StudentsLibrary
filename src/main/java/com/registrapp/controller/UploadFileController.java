package com.registrapp.controller;

import com.registrapp.configuration.FileValidator;
import com.registrapp.models.File;
import com.registrapp.models.User;
import com.registrapp.models.UserFile;
import com.registrapp.service.UserFileService;
import com.registrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadFileController {

    @Autowired
    UserService userService;

    @Autowired
    UserFileService userFileService;

    @Autowired
    FileValidator fileValidator;

    @RequestMapping(value = { "/download-files" }, method = RequestMethod.GET)
    public String addDocuments(ModelMap model) {

        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(user);

        model.addAttribute("currentUser", currentUser);

        File fileModel = new File();

        model.addAttribute("file", fileModel);

        return "user.download.files";
    }

    @RequestMapping(value = { "/download-files" }, method = RequestMethod.POST)
    public String uploadFile(@Valid File fileModel, ModelMap model, BindingResult result) throws IOException {

        fileValidator.validate(fileModel,result);

        String user = SecurityContextHolder.getContext().getAuthentication().getName();

        User currentUser = userService.getUserByEmail(user);

        model.addAttribute("currentUser", currentUser);

        if (result.hasErrors()) {

            model.addAttribute("uploadError","The file is not loaded on the website");

            return "user.download.files";
        }

        saveFile(fileModel, currentUser);

        model.addAttribute("uploadSuccess","You have successfully downloaded the file");

        return "user.download.files";
    }



    private void saveFile(File file, User user) throws IOException {

        UserFile uploadFile = new UserFile();

        MultipartFile multipartFile = file.getFile();

        uploadFile.setName(file.getName());
        uploadFile.setDescription(file.getDescription());
        uploadFile.setType(multipartFile.getContentType());
        uploadFile.setContent(multipartFile.getBytes());
        uploadFile.setNameFile(multipartFile.getOriginalFilename());
        uploadFile.setUser(user);
        multipartFile.transferTo(new java.io.File("..\\app-root\\data\\" + multipartFile.getOriginalFilename()));
        userFileService.save(uploadFile);
    }

}
