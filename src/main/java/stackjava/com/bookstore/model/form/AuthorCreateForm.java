package stackjava.com.bookstore.model.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import stackjava.com.bookstore.model.db.Author;
import stackjava.com.bookstore.util.DateUtils;
import stackjava.com.bookstore.util.FileUtils;
import stackjava.com.bookstore.validator.FileField;
import stackjava.com.bookstore.validator.StringField;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

@Data
public class AuthorCreateForm implements Serializable {
    @StringField(notEmpty = true, min = 1, max = 30)
    private String name;

    @StringField(isEmail = true, max = 30)
    private String email;

    @StringField(max = 50)
    private String address;

    @StringField(max = 15)
    private String phoneNumber;

    @StringField(max = 30)
    private String national;

    private String dateOfBirth;

    @FileField(isImage = true, max = 1024, messageMaxSize = "{avatar.size.max}")
    private MultipartFile avatar;

    public Author toAuthor() throws IOException, ParseException {
        Author author = new Author();
        author.setName(this.getName());
        author.setAddress(this.getAddress());
        author.setEmail(this.getEmail());
        author.setPhoneNumber(this.getPhoneNumber());
        if (this.getDateOfBirth() != null && this.getDateOfBirth().length()>0) {
            author.setDateOfBirth(DateUtils.DATE_FORMAT().parse(this.getDateOfBirth()));
        }

        if (this.getAvatar() != null) {
            String fileName = this.getAvatar().getOriginalFilename() + System.currentTimeMillis();
            File file = new File(FileUtils.getFolderUpload(), fileName);
            this.getAvatar().transferTo(file);
            author.setAvatar(fileName);
        }

        return author;
    }
}
