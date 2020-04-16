package com.chat.controllers;

import com.chat.model.User;
import com.chat.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;


@Controller
public class RegisterController {

    private UserService userService;

    private User Null;

    public RegisterController(UserService userService){
        this.userService = userService;

    }
    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @POST
    @RequestMapping(value = "/addUser")
    public String registerAction(@Valid User user, Errors errors) {

        String returnPage = null;

        User userExist = userService.findUserByEmail(user.getEmail());

        if (userExist!=Null) {
            errors.rejectValue("email", "error.userEmailExist");
            returnPage = "register";

        } else {
            userService.saveUser(user);

            returnPage = "login";
        }
        return returnPage;
    }
}
