package ovh.enyo.hlm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ovh.enyo.hlm.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    List<Author> findByCreated (boolean created);

    List<Author> findAll();

    Page<Author> findAll(Pageable page);

    boolean existsById(Integer id);

    boolean existsByCreatedIsFalseAndGroup_Id(Integer groupId);

    Optional<Author> findById(Integer id);

    Author save(Author entity);

    void deleteById(Integer id);





}
