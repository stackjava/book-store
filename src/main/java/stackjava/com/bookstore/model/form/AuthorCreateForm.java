package stackjava.com.bookstore.model.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import stackjava.com.bookstore.model.db.Author;
import stackjava.com.bookstore.util.FileUtils;
import stackjava.com.bookstore.validator.FileField;
import stackjava.com.bookstore.validator.StringField;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@Data
public class AuthorCreateForm implements Serializable {
    @StringField(notEmpty = true, min = 1, max = 30)
    private String name;
    private String address;
    private String national;
    private String dateOfBirth;

    @FileField(notNull = true, max = 1024, messageMaxSize = "{avatar.size.max}")
    private MultipartFile avatar;

    public Author toAuthor() throws IOException {
        Author author = new Author();
        author.setName(this.getName());
        author.setAddress(this.getAddress());
//        if (this.getDateOfBirth() != null && this.getDateOfBirth().length()>0) {
//
//        }

        if (this.getAvatar() != null) {
            String fileName = this.getAvatar().getOriginalFilename() + System.currentTimeMillis();
            File file = new File(FileUtils.getFolderUpload(), fileName);
            this.getAvatar().transferTo(file);
            author.setAvatar(fileName);
        }

        return author;
    }
}
