package com.example.springboottutorialvalidate.convertor;

import com.example.springboottutorialvalidate.dto.validate.PersonRq;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * string to person convert
 */
public class PersonConvertor implements Converter<String, PersonRq> {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public PersonRq convert(String value) {
        String[] data = value.split(",");
        PersonRq person = new PersonRq(data[0], data[1], data[2], data[3], LocalDateTime.parse(data[4], DTF));
        return person;
    }
}
