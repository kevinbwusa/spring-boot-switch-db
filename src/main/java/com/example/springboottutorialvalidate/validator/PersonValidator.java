package com.example.springboottutorialvalidate.validator;

import com.example.springboottutorialvalidate.dto.validate.PersonRq;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 用來驗證 PersonRq
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        // 判斷是否為支援的類別
        return PersonRq.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonRq person = (PersonRq) target;
        // 檢核必填
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");
        // 檢核年齡要滿18歲
        int age = Integer.parseInt(person.getAge());
        if (age < 18) {
            errors.rejectValue("age", "未成年");
        } else if (age > 65) {
            errors.rejectValue("age", "你可以退休了");
        }
    }
}
