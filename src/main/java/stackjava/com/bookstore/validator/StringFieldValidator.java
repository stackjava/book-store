package stackjava.com.bookstore.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class StringFieldValidator implements ConstraintValidator<StringField, String> {

    private Boolean notEmpty;
    private Boolean isEmail;
    private Integer min;
    private Integer max;
    private String messageNotEmpty;
    private String messageLength;
    private String messageIsEmail;

    public void initialize(StringField field) {
        notEmpty = field.notEmpty();
        isEmail = field.isEmail();
        min = field.min();
        max = field.max();
        messageNotEmpty = field.messageNotEmpty();
        messageLength = field.messageLength();
        messageIsEmail = field.messageIsEmail();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (notEmpty && StringUtils.isEmpty(value)) {
            context.buildConstraintViolationWithTemplate(messageNotEmpty).addConstraintViolation();
            return false;
        }
        if (isEmail) {
            if (StringUtils.isNotEmpty(value) && !checkEmailFormat(value)) {
                context.buildConstraintViolationWithTemplate(messageIsEmail).addConstraintViolation();
                return false;
            }
        }
        if (StringUtils.isNotEmpty(value) && (max < Integer.MAX_VALUE) && (value.length() > max)) {
            context.buildConstraintViolationWithTemplate(messageLength).addConstraintViolation();
            return false;
        }
        if ((min > 0) && (StringUtils.isEmpty(value) || (value.length() < min))) {
            context.buildConstraintViolationWithTemplate(messageLength).addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean checkEmailFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}