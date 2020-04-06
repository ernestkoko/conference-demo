package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
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

    @PostMapping
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session); // objects do not get committed to db until you flush them
                                                            // so this saveAndFlush() saves ad flush the object
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){

        // normally, you need to check for children records before deleting
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)  // i will read about PUT and PATCH
    public Session update(@PathVariable Long id, @RequestBody Session session ){
        //because this is PUT, we expect all attributes to be passed in but PATCH updates some sections of the attribute

        Session existingSession = sessionRepository.getOne(id);
        //takes the existing session and copies the incoming session to it
        BeanUtils.copyProperties(session, existingSession, "session_id");

        //then we save and flush
        return sessionRepository.saveAndFlush(existingSession);
    }
}
