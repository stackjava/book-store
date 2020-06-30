package stackjava.com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stackjava.com.bookstore.model.db.Author;
import stackjava.com.bookstore.repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepo;

    public List<Author> findAllAuthor() {
        List<Author> authorList = authorRepo.findAll();
        return authorList;
    }

    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }
}
