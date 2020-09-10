package ovh.enyo.hlm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ovh.enyo.hlm.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT b FROM Book b WHERE CONCAT(b.name, ' ', b.authors, ' ', b.genres) LIKE %?1%")
    Page<Book> findAll(String keyword, Pageable pageable);

}
