package stackjava.com.bookstore.validator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = StringFieldValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringField {

    String message() default "Wrong data of string field";

    String messageNotEmpty() default "{StringField.NotEmpty}";

    String messageLength() default "{StringField.Length}";

    boolean notEmpty() default false;

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
} 