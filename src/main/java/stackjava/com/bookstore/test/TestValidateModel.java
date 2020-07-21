package stackjava.com.bookstore.test;

import stackjava.com.bookstore.model.form.AuthorCreateForm;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class TestValidateModel {
    public static void main(String[] args) {
        AuthorCreateForm authorCreateForm = new AuthorCreateForm();
        authorCreateForm.setEmail("abdsdf");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<AuthorCreateForm>> violations = validator.validate(authorCreateForm);
        for (ConstraintViolation<AuthorCreateForm> violation : violations) {
            System.out.println(violation.getPropertyPath() +":"+ violation.getInvalidValue()+":"+violation.getMessage());
        }

    }
}
