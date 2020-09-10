package ovh.enyo.hlm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.enyo.hlm.model.Book;
import ovh.enyo.hlm.service.BookService;
import org.springframework.validation.BindingResult;
import ovh.enyo.hlm.service.NoteService;

import javax.validation.Valid;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/books", "/", "/index"})
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String viewHomePage(Model model) {
        String keyword = null;
        return viewPagedBooks(model, 1, "name", "asc", keyword);
    }

    @GetMapping("/page/{pageNumber}")
    public String viewPagedBooks(Model model, @PathVariable("pageNumber") int currentPage,
                                 @Param("sortField") String sortField,
                                 @Param("sortDir") String sortDir,
                                 @Param("keyword") String keyword) {
        Page<Book> page = bookService.getAllBooks(currentPage, sortField, sortDir, keyword);

        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<Book> listBooks = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listBooks", listBooks);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);

        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);
        return "books";
    }

    @GetMapping("addBook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";

    }

    @PostMapping("addBook")
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult result) {

        if (result.hasErrors())
            return "new_book";

        bookService.saveBook(book);
        return "redirect:/";
    }


    @PostMapping("updateBook")
    public String updateBook(@ModelAttribute("book") @Valid Book book, BindingResult result) {

        if (result.hasErrors())
                return "update_book";

        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("updateBook/{id}")
    public String updateBook(@PathVariable int id, Model model) {
        Optional<Book> temp = bookService.getBookById(id);
        Book book;
        if(temp.isEmpty())
            throw new IllegalStateException("Book with id=" + id + " could not be found!");
        else
            book = temp.get();

        model.addAttribute("book", book);

        return "update_book";
    }

    @GetMapping("detailsBook/{id}")
    public String detailsBook(@PathVariable int id, Model model) {
        Optional<Book> temp = bookService.getBookById(id);
        Book book;
        if(temp.isEmpty())
            throw new IllegalStateException("Book with id=" + id + " could not be found!");
        else
            book = temp.get();

        model.addAttribute("book", book);

        return "details_book";

    }

    @GetMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable int id) {
        this.bookService.deleteBookById(id);
        return "redirect:/";
    }

}
