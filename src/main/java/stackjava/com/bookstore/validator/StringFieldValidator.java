package stackjava.com.bookstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringFieldValidator implements ConstraintValidator<StringField, String> {

    private Boolean notEmpty;
    private Integer min;
    private Integer max;
    private String messageNotEmpty;
    private String messageLength;

    public void initialize(StringField field) {
        notEmpty = field.notEmpty();
        min = field.min();
        max = field.max();
        messageNotEmpty = field.messageNotEmpty();
        messageLength = field.messageLength();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (notEmpty && value.isEmpty()) {
            context.buildConstraintViolationWithTemplate(messageNotEmpty).addConstraintViolation();
            return false;
        }
        if ((min > 0 || max < Integer.MAX_VALUE) &&
                (value.isEmpty() || (value.length() < min || value.length() > max))) {
            context.buildConstraintViolationWithTemplate(messageLength).addConstraintViolation();
            return false;
        }
        return true;
    }
}