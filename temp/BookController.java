//package ovh.enyo.hlm.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ovh.enyo.hlm.model.Book;
//import ovh.enyo.hlm.service.BookService;
//
//@Controller
//@RequestMapping("/")
//public class BookController {
//    @Autowired
//    private BookService bookService;
//
//    @GetMapping
//    public String viewBooks(Model model) {
//        model.addAttribute("bookList", bookService.getAllBooks());
//        return "index";
//    }
//
//    @GetMapping("addBook")
//    public String addBook(Model model) {
//        Book book = new Book();
//        model.addAttribute("book", book);
//        return "new_book";
//
//    }
//
//    @PostMapping("saveBook")
//    public String saveBook(@ModelAttribute("book") Book book) {
//        bookService.saveBook(book);
//        return "redirect:/";
//    }
//
//    @GetMapping("updateBook/{id}")
//    public String updateBook(@PathVariable int id, Model model) {
//        Book book = bookService.getBookById(id);
//        model.addAttribute("book", book);
//
//        return "update_book";
//    }
//
//    @GetMapping("deleteBook/{id}")
//    public String deleteBook(@PathVariable int id) {
//        this.bookService.deleteBookById(id);
//        return "redirect:/";
//    }
//
//
//
//
//
//
//
//    /*
//    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
//
//
//
//
//    private final BookRepository repository;
//
//
//
//
//    public BookController(@Qualifier("bookRepository") BookRepository repository) {
//        this.repository = repository;
//    }
//
//
//    @PostMapping("/create")
//    ResponseEntity<Book> createBook(@RequestBody @Valid Book toCreate) {
//        logger.warn("Creating book!");
//
//        Book result = repository.save(toCreate);
////        Set<Author> authors = toCreate.getAuthors();
////        for(Iterator<Author> it = authors.iterator(); it.hasNext();) {
////            Author a = it.next();
////            result.addAuthor(a);
////        }
//
//
//        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
//    }
//
//
//
//    @GetMapping
//    ResponseEntity<List<Book>> getBooks() {
//        logger.warn("Exposing all the books!");
//        return ResponseEntity.ok(repository.findAll());
//    }
//
//
//    @GetMapping("/details1/{id}")
//    ResponseEntity<Book> getBook(@PathVariable int id) {
//        logger.warn("Exposing one book!");
//        return repository.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/edit/{id}")
//    ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody @Valid Book toUpdate) {
//        logger.warn("Updating book!");
//        if(!checkIfExists(id))
//            return ResponseEntity.notFound().build();
//
//        repository.findById(id)
//                .ifPresent(book -> {
//                    book.updateFrom(toUpdate);
//                    repository.save(book);
//                });
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/delete/{id}")
//    ResponseEntity<Book> deleteBookById(@PathVariable int id) {
//        logger.warn("Deleting book!");
//        if(!checkIfExists(id))
//            return ResponseEntity.notFound().build();
//
//        repository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    private boolean checkIfExists(@PathVariable int id) {
//        return repository.existsById(id);
//    }
//*/
//}
