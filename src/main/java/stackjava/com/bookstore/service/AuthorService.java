package stackjava.com.bookstore.service;

import org.springframework.stereotype.Service;
import stackjava.com.bookstore.model.Author;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    public List<Author> findAllAuthor() {
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(1, "Phương Mai", "VN", "phuongmai@gmail.com", "0123456789", ""));
        authorList.add(new Author(2, "Gào", "VN", "", "gao@gmail.com", ""));
        authorList.add(new Author(3, "Tony Buổi Sáng", "VN", "tony@gmail.com", "", ""));
        authorList.add(new Author(4, "Nguyễn Nhật Ánh", "VN", "nguyennhatanh@gmail.com", "", ""));
        return authorList;
    }
}
