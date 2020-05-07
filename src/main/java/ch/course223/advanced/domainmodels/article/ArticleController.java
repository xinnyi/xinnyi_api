package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.domainmodels.article.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    public ResponseEntity<List<ArticleDTO>> findAll(){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.findAll()), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ArticleDTO> save(@RequestBody ArticleDTO articleDTO) {
        return new ResponseEntity<>(articleMapper.toDTO(articleService.save(articleMapper.fromDTO(articleDTO))), HttpStatus.CREATED);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<ArticleDTO>> findArticlesByTitle(@PathVariable String search){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.searchArticle(search)), HttpStatus.OK);
    }

    @GetMapping("/inverted/{search}")
    public ResponseEntity<List<ArticleDTO>> reverseSearchTitle(@PathVariable String search){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.reverseSearchArticle(search)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable String id){
        articleService.deleteArticle(id);
    }
}
