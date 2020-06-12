package com.example.demo.common;

import com.example.demo.util.StringUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsIdCardNoValidator implements ConstraintValidator<IsIdCardNo, String> {

    @Override
    public void initialize(IsIdCardNo constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtil.isNullOrWhiteSpace(s))   // 不校验空字符
            return true;

        String id15 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$";
        String id18 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

        if (s.matches(id15) || s.matches(id18))
            return true;
        return false;
    }
}
