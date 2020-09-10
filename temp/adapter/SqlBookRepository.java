package ovh.enyo.hlm.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ovh.enyo.hlm.model.Book;
import ovh.enyo.hlm.repository.BookRepository;

@Repository
public
interface SqlBookRepository extends BookRepository, JpaRepository<Book, Integer> {
//    @Override
//    @Query(nativeQuery = true,value = "select count(*) > 0 from authors where id=?1")
//    boolean existsById(@Param("id") Integer id);

}
