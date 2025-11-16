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


    //Post Endpoints
    //Register account
    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<User> registerAccount(@RequestBody User user){
        if(user.getUsername().length() >= 1){
            
        }
        return null;
    }

    //Login to existing account
    @PostMapping(value = "/login")
    public @ResponseBody ResponseEntity<User> verifyAccount(@RequestBody String username, Integer password){
        return null;
    }

    //submit Morning Quiz
    @PostMapping(value = "/submitMQ")
    public @ResponseBody ResponseEntity<MorningQuiz> submitMorningQuiz(@RequestBody MorningQuiz morningQuiz){
        return null;
    }

    //submit Night Quiz
    @PostMapping(value = "/submitNQ")
    public @ResponseBody ResponseEntity<NightQuiz> submitNightQuiz(@RequestBody NightQuiz){
        return null;
    }

    //submit Hours Log
    @PostMapping(value = "/submitHL")
    public @ResponseBody ResponseEntity<HoursLog> submitHoursLog(@RequestBody HoursLog hoursLog){
        return null;
    }

    //submit Journal Entry
    @PostMapping(value = "/submitJE")
    public @ResponseBody ResponseEntity<JournalEntry> submitJournalEntry(@RequestBody JournalEntry JournalEntry){
        return null;
    }

    //GET endpoints

    //get a single morning quiz by id/date (&user)
    //get all morning quizzes by user
    //get a single night quiz by id (&user)
    //get all night quizzes by user
    //get a single hours log by id (&user)
    //get all hours logs by user
    //get all hours logs by date (&user)
    //get a single journal entry by id (&user)
    //get all journal entries by user
    //get all profile information by user

}