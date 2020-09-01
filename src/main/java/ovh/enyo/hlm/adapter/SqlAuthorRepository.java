package ovh.enyo.hlm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ovh.enyo.hlm.model.Author;

@Repository
interface SqlAuthorRepository extends AuthorRepository, JpaRepository<Author, Integer> {
    @Override
    @Query(nativeQuery = true,value = "select count(*) > 0 from authors where id=?1")
    boolean existsById(@Param("id") Integer id);

    @Override
    boolean existsByCreatedIsFalseAndGroup_Id(Integer groupId);
}
