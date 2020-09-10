package ovh.enyo.hlm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ovh.enyo.hlm.model.Book;
import ovh.enyo.hlm.model.Note;
import ovh.enyo.hlm.repository.BookRepository;
import ovh.enyo.hlm.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;


    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Page<Note> getAllNotes(int pageNumber, String sortField, String sortDir, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort);
        if(keyword != null) {
            return noteRepository.findAll(keyword, pageable);
        }
        return noteRepository.findAll(pageable);
    }


    @Override
    public boolean checkIfNoteExists(Integer id) {
        return noteRepository.existsById(id);
    }

    @Override
    public Optional<Note> getNoteById(Integer id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note saveNote(Note entity) {
        return noteRepository.save(entity);
    }

    @Override
    public void deleteNoteById(Integer id) {
        noteRepository.deleteById(id);
    }
}
