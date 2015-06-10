package kr.ac.jeju.controller.login;

import kr.ac.jeju.model.LoginCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return LoginCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
    }
}
