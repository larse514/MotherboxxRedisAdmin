package com.motherboxx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
/*
 * author: Crunchify.com
 * 
 */
 
@RestController
@RequestMapping("/")
public class MainController {
 
    @RequestMapping(value = "/greeting", produces="application/json", method = RequestMethod.GET)
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("HelloWorld", HttpStatus.OK);
    }
}