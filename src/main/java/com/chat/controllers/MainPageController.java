package com.chat.controllers;

import com.chat.model.User;
import com.chat.services.UserService;
import com.chat.utilities.UserUtilities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class MainPageController {

    private UserService userService;

    public MainPageController(UserService userService){
        this.userService = userService;
    }

    @GET
    @RequestMapping({"", "/", "/index"})
    public String showMainPage(){
        return "index";
    }

    @GET
    @RequestMapping(value = "/titles")
    public String showTitlesPage(Model model){
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        assert user != null;
        int roleNr = user.getRoles().iterator().next().getId();
        user.setRoleNumber(roleNr);
        model.addAttribute("user", user);
        return "titles";
    }

    @GET
    @RequestMapping(value = "/chat")
    public String showUserChatPage(Model model){
        String username = UserUtilities.getLoggedUser();

        User user = userService.findUserByEmail(username);
        assert user != null;
        int nrRoli = user.getRoles().iterator().next().getId();
        user.setRoleNumber(nrRoli);
        model.addAttribute("user", user);
        return "chat";
    }
}
