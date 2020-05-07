package ch.course223.advanced.domainmodels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static org.elasticsearch.index.query.Operator.AND;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        List<Article> articleList = new LinkedList<>();
        articleRepository.findAll().forEach(articleList::add);
        return articleList;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(String id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> findByTitle(String title) {
       return articleRepository.findByTitle(title);
    }

    @Override
    public List<Article> reverseSearchTitle(String title) {
        List<Article> reversedSearch = new LinkedList<>();

        articleRepository.findAll().forEach(article -> {
            if(!(article.getTitle().toLowerCase()).contains(title.toLowerCase())){
                reversedSearch.add(article);
            }
        });

        return reversedSearch;
    }
}
