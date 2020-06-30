package stackjava.com.bookstore.validator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = FileFieldValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface FileField {

    String message() default "FileField Error";

    String messageNotNull() default "{FileFile.NotNull}";

    String messageMinSize() default "{FileField.MinSize}";

    String messageMaxSize() default "{FileField.MaxSize}";

    boolean notNull() default false;

    long min() default 0;

    long max() default Long.MAX_VALUE;

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
} 