package com.example.Controller;

import com.example.entity.Account;
import com.example.service.AccountService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedEyeController{
    @Autowired
    public AccountService accountService;

    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<Account> registerAccount(@RequestBody Account account){
        if(account.getUsername().length() >= 1){
            
        }
    }
}