package ovh.enyo.hlm.service;

import org.springframework.data.domain.Page;
import ovh.enyo.hlm.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

//    List<Book> getAllBooks(String keyword);

    Page<Book> getAllBooks(int pageNumber, String sortField, String sortDir, String keyword);

    boolean checkIfBookExists(Integer id);

    Optional<Book> getBookById(Integer id);

    Book saveBook(Book entity);

    void deleteBookById(Integer id);


}
