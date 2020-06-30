package stackjava.com.bookstore.validator;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileFieldValidator implements ConstraintValidator<FileField, MultipartFile> {

    private Boolean notNull;
    private Boolean isImage;
    private Long min;
    private Long max;
    private String messageNotNull;
    private String messageMinSize;
    private String messageMaxSize;
    private String messageIsImage;

    public void initialize(FileField field) {
        notNull = field.notNull();
        isImage = field.isImage();
        min = field.min();
        max = field.max();
        messageNotNull = field.messageNotNull();
        messageMinSize = field.messageMinSize();
        messageMaxSize = field.messageMaxSize();
        messageIsImage = field.messageIsImage();
    }

    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        if (notNull && (value == null || value.isEmpty())) {
            context.buildConstraintViolationWithTemplate(messageNotNull).addConstraintViolation();
            return false;
        }
        if (notNull && isImage) {
            if (value.getContentType() == null || !value.getContentType().contains("image")) {
                context.buildConstraintViolationWithTemplate(messageIsImage).addConstraintViolation();
                return false;
            }
        }
        if (notNull) {
            long fileSize = value.getSize()/1024;
            if (min > 0  && fileSize < min ) {
                context.buildConstraintViolationWithTemplate(messageMinSize).addConstraintViolation();
                return false;
            }
            if (max < Long.MAX_VALUE && fileSize > max) {
                context.buildConstraintViolationWithTemplate(messageMaxSize).addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}