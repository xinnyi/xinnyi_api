package ch.course223.advanced.domainmodels.article;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    List<Article> findByArticle(String title);
}