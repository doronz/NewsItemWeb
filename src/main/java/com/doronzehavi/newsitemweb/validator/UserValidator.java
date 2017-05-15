package com.doronzehavi.newsitemweb.validator;

import com.doronzehavi.newsitemweb.model.user.User;
import com.doronzehavi.newsitemweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String ID_PATTERN = "[0-9]+";
    private static final String STRING_PATTERN = "[a-zA-Z]+";
    private static final String MOBILE_PATTERN = "[0-9]{10}";


    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "Required.user.email", "Email is required.");


        if (!(user.getEmail() != null && user.getEmail().isEmpty())) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(user.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "Invalid.user.email",
                        "Enter a valid email");
            }
            if (userService.findByEmail(user.getEmail()) != null){
                errors.rejectValue("email", "Duplicate.user.email",
                        "This email is already registered");
            }
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
            if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
                errors.rejectValue("username", "Size.user.username", "6 to 32 character username");
            }
            if (userService.findByUsername(user.getUsername()) != null) {
                errors.rejectValue("username", "Duplicate.user.username", "Duplicate username, choose another");
            }

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
            if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
                errors.rejectValue("password", "Size.user.password", "6 to 32 character password");
            }

        }
    }
}
