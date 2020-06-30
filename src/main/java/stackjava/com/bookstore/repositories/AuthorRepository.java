package stackjava.com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stackjava.com.bookstore.model.db.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
