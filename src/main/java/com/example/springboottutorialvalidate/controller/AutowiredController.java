package com.example.springboottutorialvalidate.controller;

import com.example.springboottutorialvalidate.service.auto.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auto")
public class AutowiredController {

    @Autowired
    private AutoService autoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String autoTest() {
        autoService.run();
        return "finish";
    }
}
