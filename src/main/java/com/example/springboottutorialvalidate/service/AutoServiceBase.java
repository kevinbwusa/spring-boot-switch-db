package com.example.springboottutorialvalidate.service;

import com.example.springboottutorialvalidate.util.auto.AutoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AutoServiceBase {

    @Autowired
    protected AutoUtil autoUtil;
}
