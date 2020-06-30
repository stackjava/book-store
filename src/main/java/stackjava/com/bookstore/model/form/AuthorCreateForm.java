package stackjava.com.bookstore.model.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import stackjava.com.bookstore.validator.FileField;
import stackjava.com.bookstore.validator.StringField;

import java.io.Serializable;

@Data
public class AuthorCreateForm implements Serializable {
    @StringField(notEmpty = true, min = 1, max = 30)
    private String name;
    private String address;
    private String national;
    private int age;

    @FileField(notNull = true, max = 1024, messageMaxSize = "{avatar.size.max}")
    private MultipartFile avatar;
}
