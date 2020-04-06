package com.pluralsight.conferencedemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //this makes this class the controller. All requests to this below url will be sent to this controller
@RequestMapping("api/v1/sessions") //this is what the mapping url will look like
public class SessionsController {
}
