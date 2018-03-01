package com.lanu.sambamedia.controllers;

import com.lanu.sambamedia.entities.User;
import com.lanu.sambamedia.services.TaskService;
import com.lanu.sambamedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        String email = principal.getName();
        User user = userService.findOne(email);
        model.addAttribute("tasks", taskService.findUserTask(user));
        return "views/profile";
    }
}
