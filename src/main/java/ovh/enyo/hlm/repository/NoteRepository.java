package ovh.enyo.hlm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ovh.enyo.hlm.model.Book;
import ovh.enyo.hlm.model.Note;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
//    @Query("SELECT n FROM Note n WHERE n.title LIKE %?1%")
    @Query("SELECT n FROM Note n WHERE CONCAT(n.title, ' ', n.content, ' ', n.book.name) LIKE %?1%")
    Page<Note> findAll(String keyword, Pageable pageable);


}
