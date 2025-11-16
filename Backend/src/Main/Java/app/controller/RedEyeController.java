package app.controller;

import java.util.ArrayList;
import java.util.List;

import app.service.*;
import app.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedEyeController{
    @Autowired
    public UserService userService;

    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<User> registerAccount(@RequestBody User user){
        if(user.getUsername().length() >= 1){
            
        }
        return null;
    }
}