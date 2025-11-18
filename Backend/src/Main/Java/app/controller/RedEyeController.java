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

    @Autowired
    public MorningQuizService morningQuizService;

    @Autowired
    public NightQuizService nightQuizService;

    @Autowired
    public HoursLog hoursLog;

    @Autowired
    public JournalEntry journalEntry;


    //Post Endpoints
    //Register account
    @PostMapping(value = "/register")
    public @ResponseBody ResponseEntity<User> registerAccount(@RequestBody User user){
        //username must be longer than 4 chars
        if(user.getUsername().length() > 4){
            //password must be longer than 4 chars
            if(user.getPassword().length() > 4){
                //username must not exist already
                if(userService.getUserByUsername(user.getUsername()) == null){
                    user.setPassword(hashPassword(user.getPassword()));
                    userService.addUser(user);
                    return ResponseEntity.status(200).body(user);
                }
                return ResponseEntity.status(409).body(new User());
            }
        }
        return ResponseEntity.status(400).body(new User()); //client error, return empty account
    }

    //Login to existing account
    @PostMapping(value = "/login")
    public @ResponseBody ResponseEntity<User> verifyAccount(@RequestBody User user){
        if(user.getUsername().length() > 4){
            User search = userService.getUserByUsername(user.getUsername());
            if(search != null){
                if(PasswordUtil.checkPassword(user.getPassword(), search.getPassword())){
                    return ResponseEntity.status(200).body(search);                }
            }
        }
        return ResponseEntity.status(401).body(new User());
    }

    //submit Morning Quiz
    @PostMapping(value = "/morningQuiz")
    public @ResponseBody ResponseEntity<MorningQuiz> submitMorningQuiz(@RequestBody MorningQuiz morningQuiz){
        //ONLY ONE MORNING QUIZ PER DAY PER USER
        MorningQuiz search = morningQuizService.testGetMorningQuizByUserIdAndDate(morningQuiz.getUserId(), morningQuiz.getDate());
        //Either the quiz already exists on a given date with a given user
        if(search != null){
            ResponseEntity.status(400).body(search);
        }else{
            ResponseEntity.status(200).body(morningQuiz);
        }
        ResponseEntity.status(401).body(new MorningQuiz());
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