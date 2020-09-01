package ovh.enyo.hlm.repository;

import org.springframework.stereotype.Repository;
import ovh.enyo.hlm.model.AuthorGroup;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorGroupRepository {
    List<AuthorGroup> findAll();

    Optional<AuthorGroup> findById(Integer id);

    AuthorGroup save(AuthorGroup entity);

}
