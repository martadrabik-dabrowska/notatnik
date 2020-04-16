package com.chat.controllers;



import com.chat.model.User;
import com.chat.services.AdminService;
import com.chat.services.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import java.util.List;



@Controller
@Secured(value = {"ROLE_ADMIN"})
public class AdminController {

    private AdminService adminService;

    private UserService userService;

    public AdminController(AdminService adminService, UserService userService){
        this.adminService=adminService;
        this.userService=userService;
    }

    @GET
    @RequestMapping(value = "/admin")
    public String showAdminPage(){
        return "admin/admin";
    }

    @GET
    @RequestMapping(value = "/admin/users")
    public String showAllUsersPage(Model model){

        List<User> userList = getAllUsers();
        model.addAttribute("userList", userList);
        return "admin/users";
    }
    private List<User> getAllUsers(){

        List<User> userList = userService.findAll();
        for(User users : userList){
            int roleNr = users.getRoles().iterator().next().getId();
            users.setRoleNumber(roleNr);
        }
        return userList;
    }

    @GET
    @RequestMapping(value = "/admin/users/search/{searchWord}")
    public String openSearchUsersPage(@PathVariable("searchWord") String searchWord, Model model){
        List<User> userList = adminService.findAllSearch(searchWord);
        model.addAttribute("searchWord", searchWord);
        for(User users : userList){
            int roleNr = users.getRoles().iterator().next().getId();
            users.setRoleNumber(roleNr);
        }

        model.addAttribute("userList", userList);
        return "admin/usersearch";
    }

    @DELETE
    @RequestMapping(value = "/admin/users/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        adminService.deleteUserById(id);
        return "redirect:/admin/users";
    }
}
