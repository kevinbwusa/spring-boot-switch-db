package com.example.springboottutorialvalidate.dto.validate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRq {

    private String age;

    private String gender;

    private String phoneNumber;

    private String name;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private LocalDateTime updateTime;
}
