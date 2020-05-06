package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.domainmodels.article.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;
    private ArticleMapper articleMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @PostMapping("/{url}/{messengerUserId}")
    public ResponseEntity<Void> addWithMessengerUserId(@PathVariable String url, @PathVariable String messengerUserId, LocalDateTime localDateTime) {
        articleService.addWithMessengerUserId(messengerUserId, url, localDateTime);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
