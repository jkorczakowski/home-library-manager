//package ovh.enyo.hlm.service;
//
//import ovh.enyo.hlm.model.Book;
//import ovh.enyo.hlm.model.paging.Page;
//import ovh.enyo.hlm.model.paging.PagingRequest;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Predicate;
//
//public interface BookService {
//
//    List<Book> getAllBooks();
//
//    boolean checkIfBookExists(Integer id);
//
//    Book getBookById(Integer id);
//
//    Book saveBook(Book entity);
//
//    void deleteBookById(Integer id);
//
//    Page<Book> getAllBooks(PagingRequest pagingRequest);
//
//    Page<Book> getPage(List<Book> books, PagingRequest pagingRequest);
//
//    Predicate<Book> filterBooks(PagingRequest pagingRequest);
//
//    Comparator<Book> sortBooks(PagingRequest pagingRequest);
//
//
//
//}
