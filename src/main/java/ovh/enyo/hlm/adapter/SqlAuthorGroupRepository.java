package ovh.enyo.hlm.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ovh.enyo.hlm.model.AuthorGroup;
import ovh.enyo.hlm.repository.AuthorGroupRepository;

import java.util.List;

@Repository
interface SqlAuthorGroupRepository extends AuthorGroupRepository, JpaRepository<AuthorGroup, Integer> {
    @Override
    @Query("from AuthorGroup g join fetch g.authors")
    List<AuthorGroup> findAll();
}
