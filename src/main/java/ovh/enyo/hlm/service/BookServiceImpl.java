package ovh.enyo.hlm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ovh.enyo.hlm.model.Book;
import ovh.enyo.hlm.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getAllBooks(int pageNumber, String sortField, String sortDir, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort);
        if(keyword != null) {
            return bookRepository.findAll(keyword, pageable);
        }
        return bookRepository.findAll(pageable);
    }


    @Override
    public boolean checkIfBookExists(Integer id) {
        return bookRepository.existsById(id);
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book entity) {
        if(entity.getName().isEmpty())
            throw new IllegalArgumentException("ERROR: name cannot be empty!");
        return bookRepository.save(entity);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
}
