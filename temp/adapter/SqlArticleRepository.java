package ovh.enyo.hlm.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ovh.enyo.hlm.model.Article;
import ovh.enyo.hlm.repository.ArticleRepository;

@Repository
interface SqlArticleRepository extends ArticleRepository, JpaRepository<Article, Integer> {
//    @Override
//    @Query(nativeQuery = true,value = "select count(*) > 0 from authors where id=?1")
//    boolean existsById(@Param("id") Integer id);

}
