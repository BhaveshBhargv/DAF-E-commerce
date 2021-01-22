package com.DFA.ecommerce.controler;

import com.DFA.ecommerce.models.Users;
import com.DFA.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    @RequestMapping(path = "/add")
    public void addUser(@RequestBody Users users) {
        userService.addUser(users);
    }

    @PostMapping
    @RequestMapping(path = "/delete")
    public void deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
    }

}