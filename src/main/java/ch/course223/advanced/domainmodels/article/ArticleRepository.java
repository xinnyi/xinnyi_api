package ch.course223.advanced.domainmodels.article;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    List<Article> findByArticleAndUserId(String title, String userId);
    List<Article> findAllByUserId(String userId);
}