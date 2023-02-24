package com.example.springboottutorialvalidate.service.validate;

import com.example.springboottutorialvalidate.dto.validate.PersonBinding;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataBindingService {

    public PersonBinding webDataBinderTest() {
        PersonBinding person = new PersonBinding();
        WebDataBinder binder = new WebDataBinder(person, "person");

        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("name", "tom");
        //
        pvs.add("!name", "jay");
        List<String> nickNameList = new ArrayList<>();
        nickNameList.add("default");
        // _用在給特定類別一個空值（Map, Array, Collection, Boolean）
        pvs.add("nickNameList", nickNameList);
        pvs.add("_nickNameList", null);
        // TODO

        binder.bind(pvs);
        return person;
    }
}
