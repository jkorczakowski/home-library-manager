package ovh.enyo.hlm.service;

import org.springframework.data.domain.Page;
import ovh.enyo.hlm.model.Book;
import ovh.enyo.hlm.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> getAllNotes();

    Page<Note> getAllNotes(int pageNumber, String sortField, String sortDir, String keyword);

    boolean checkIfNoteExists(Integer id);

    Optional<Note> getNoteById(Integer id);

    Note saveNote(Note entity);

    void deleteNoteById(Integer id);
}
