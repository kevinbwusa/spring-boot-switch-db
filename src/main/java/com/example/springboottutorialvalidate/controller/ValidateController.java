package com.example.springboottutorialvalidate.controller;

import com.example.springboottutorialvalidate.dto.validate.PersonRq;
import com.example.springboottutorialvalidate.service.validate.DataBindingService;
import com.example.springboottutorialvalidate.validator.PersonValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate")
@Slf4j
public class ValidateController {

    @Autowired
    private DataBindingService dataBindingService;

    @RequestMapping(value = "/bind", method = RequestMethod.GET)
    public ResponseEntity<Object> bindTest() {
        return ResponseEntity.ok(dataBindingService.webDataBinderTest());
    }

    @RequestMapping(value = "/old", method = RequestMethod.POST)
    public ResponseEntity<Object> oldValidate(@RequestBody PersonRq person) {
        // bind person object
        DataBinder binder = new DataBinder(person);
        // 在綁定物件後再將validator set 到這個binding上
        binder.setValidator(new PersonValidator());
        // 關於binder的設定(還有好幾個...)
        binder.setIgnoreUnknownFields(false);
        binder.setAllowedFields();
        binder.setDisallowedFields();
        // 關於binder的get
        binder.getObjectName();
        binder.getDisallowedFields();
        binder.getValidator();
        // validate
        binder.validate();
        // result
        BindingResult bdResult = binder.getBindingResult();
        log.info("validate results:{}", bdResult);

        return ResponseEntity.ok(person);
    }


    @RequestMapping(value = "/old", method = RequestMethod.GET)
    public ResponseEntity<Object> oldConvertor(@RequestParam("param") PersonRq person) {
        return ResponseEntity.ok(person);
    }
}
