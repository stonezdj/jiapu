package com.zdj.jiapu.domain.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordEqualsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return JiapuUser.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	JiapuUser form = (JiapuUser) target;
        String password = form.getPassword();
        String repeatedPassword = form.getRepeatpwd();
        if (password == null || repeatedPassword == null) {
            return;
        }
        if (!password.equals(repeatedPassword)) {
            errors.rejectValue("password",
                    "PasswordEqualsValidator.jiapuUser.password",
                    "两次输入的密码不匹配！");
        }
    }

}
