package ovh.enyo.hlm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ovh.enyo.hlm.model.Book;
import ovh.enyo.hlm.model.Note;
import ovh.enyo.hlm.service.BookService;
import ovh.enyo.hlm.service.NoteService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private BookService bookService;

    @GetMapping
    public String viewHomePage(Model model) {
        String keyword = null;
        return viewPagedNotes(model, 1, "title", "asc", keyword);
    }

    @GetMapping("/page/{pageNumber}")
    public String viewPagedNotes(Model model, @PathVariable("pageNumber") int currentPage,
                                 @Param("sortField") String sortField,
                                 @Param("sortDir") String sortDir,
                                 @Param("keyword") String keyword) {
        Page<Note> page = noteService.getAllNotes(currentPage, sortField, sortDir, keyword);

        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<Note> listNotes = page.getContent();

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listNotes", listNotes);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);

        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);
        return "notes";
    }

    @GetMapping("/addNote")
    public String addNote(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        List<Book> bList = bookService.getAllBooks();
        model.addAttribute("books", bList);
        return "new_note";
    }

    @PostMapping("/addNote")
    public String saveNote(@ModelAttribute("note") @Valid Note note, BindingResult result) {
       if (result.hasErrors())
           return "new_note";

        noteService.saveNote(note);
        return "redirect:/notes";
    }

    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute("note")  @Valid Note note, BindingResult result) {
        if (result.hasErrors())
            return "update_note";
        noteService.saveNote(note);
        return "redirect:/notes";
    }

    @GetMapping("/updateNote/{id}")
    public String updateNote(@PathVariable int id, Model model) {
        Optional<Note> temp = noteService.getNoteById(id);
        Note note;
        if(temp.isEmpty())
            throw new IllegalStateException("Note with id=" + id + " could not be found!");
        else
            note = temp.get();
        model.addAttribute("note", note);

        List<Book> bList = bookService.getAllBooks();
        model.addAttribute("books", bList);
        return "update_note";
    }

    @GetMapping("/detailsNote/{id}")
    public String detailsNote(@PathVariable int id, Model model) {
        Optional<Note> temp = noteService.getNoteById(id);
        Note note;
        if(temp.isEmpty())
            throw new IllegalStateException("Note with id=" + id + " could not be found!");
        else
            note = temp.get();
        model.addAttribute("note", note);
        List<Book> bList = bookService.getAllBooks();
        model.addAttribute("books", bList);

        return "details_note";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable int id) {
        this.noteService.deleteNoteById(id);
        return "redirect:/notes";
    }
}
