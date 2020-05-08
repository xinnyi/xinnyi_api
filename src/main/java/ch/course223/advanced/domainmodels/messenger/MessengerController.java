package ch.course223.advanced.domainmodels.messenger;

import ch.course223.advanced.domainmodels.article.ArticleDTO;
import ch.course223.advanced.domainmodels.article.ArticleService;
import ch.course223.advanced.domainmodels.article.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messenger")
public class MessengerController {

    private MessengerServiceImpl messengerServiceImpl;
    private ArticleMapper articleMapper;
    private ArticleService articleService;

    @Autowired
    public MessengerController(MessengerServiceImpl messengerServiceImpl, ArticleMapper articleMapper, ArticleService articleService) {
        this.messengerServiceImpl = messengerServiceImpl;
        this.articleMapper = articleMapper;
        this.articleService = articleService;
    }

    @PostMapping({"/{messengerUserId}/{deviceLinkingToken}", "/{messengerUserId}/{deviceLinkingToken}/"})
    public ResponseEntity<Void> linkDeviceToUser(@PathVariable String messengerUserId, @PathVariable String deviceLinkingToken) {
        messengerServiceImpl.linkDeviceToUser(messengerUserId, deviceLinkingToken);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/articles")
    public ResponseEntity<List<ArticleDTO>> findArticlesByArticle(@PathVariable String userId){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.getArticlesByUserId(userId)), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{search}")
    public ResponseEntity<List<ArticleDTO>> findArticlesByArticle(@PathVariable String userId, @PathVariable String search){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.searchArticle(userId, search)), HttpStatus.OK);
    }

    @GetMapping("/{userId}/inverted/{search}")
    public ResponseEntity<List<ArticleDTO>> reverseSearchArticle(@PathVariable String userId, @PathVariable String search){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.reverseSearchArticle(userId, search)), HttpStatus.OK);
    }
}
