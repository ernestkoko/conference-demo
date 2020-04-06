package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //this makes this class the controller. All requests to this below url will be sent to this controller
@RequestMapping("/api/v1/sessions") //this is what the mapping url will look like
public class SessionsController {

    //@Autowired autowires this controller
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }
//
//    @PostMapping
//    public Session create(@RequestBody final Session session){
//        return sessionRepository.saveAndFlush(session);
//    }
}
