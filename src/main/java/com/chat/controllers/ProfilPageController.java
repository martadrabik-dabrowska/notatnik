package com.chat.controllers;

import com.chat.model.User;
import com.chat.services.UserService;
import com.chat.utilities.UserUtilities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;

@Controller
public class ProfilPageController {

    private UserService userService;

    public ProfilPageController(UserService userService){
        this.userService = userService;
    }

    @GET
    @RequestMapping(value = "/profil")
    public String showUserProfilPage(Model model){
        String username = UserUtilities.getLoggedUser();
        User user = userService.findUserByEmail(username);
        assert user != null;
        int roleNr = user.getRoles().iterator().next().getId();
        user.setRoleNumber(roleNr);
        model.addAttribute("user", user);
        return "profil";
    }
}
