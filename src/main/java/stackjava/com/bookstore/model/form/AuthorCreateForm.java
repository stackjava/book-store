package stackjava.com.bookstore.model.form;

import lombok.Data;
import stackjava.com.bookstore.validator.StringField;

@Data
public class AuthorCreateForm {
    @StringField(notEmpty = true, min = 1, max = 20)
    private String name;
    private String address;
    private String national;
    private int age;
}
