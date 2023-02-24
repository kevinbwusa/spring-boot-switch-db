//package com.example.springboottutorialvalidate.convertor;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class LocalDateTimeConvertor implements Converter<String, LocalDateTime> {
//
//    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    @Override
//    public LocalDateTime convert(String value) {
//        return LocalDateTime.parse(value, DTF);
//    }
//}
