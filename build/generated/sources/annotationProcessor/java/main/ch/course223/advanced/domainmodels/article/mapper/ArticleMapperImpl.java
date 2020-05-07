package ch.course223.advanced.domainmodels.article.mapper;

import ch.course223.advanced.domainmodels.article.Article;
import ch.course223.advanced.domainmodels.article.ArticleDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-07T08:53:47+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public Article fromDTO(ArticleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Article article = new Article();

        article.setId( dto.getId() );
        article.setUserId( dto.getUserId() );
        article.setArticle( dto.getArticle() );
        article.setTimestamp( dto.getTimestamp() );

        return article;
    }

    @Override
    public List<Article> fromDTOs(List<ArticleDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Article> list = new ArrayList<Article>( dtos.size() );
        for ( ArticleDTO articleDTO : dtos ) {
            list.add( fromDTO( articleDTO ) );
        }

        return list;
    }

    @Override
    public Set<Article> fromDTOs(Set<ArticleDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Article> set = new HashSet<Article>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( ArticleDTO articleDTO : dtos ) {
            set.add( fromDTO( articleDTO ) );
        }

        return set;
    }

    @Override
    public ArticleDTO toDTO(Article Article) {
        if ( Article == null ) {
            return null;
        }

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId( Article.getId() );
        articleDTO.setUserId( Article.getUserId() );
        articleDTO.setArticle( Article.getArticle() );
        articleDTO.setTimestamp( Article.getTimestamp() );

        return articleDTO;
    }

    @Override
    public List<ArticleDTO> toDTOs(List<Article> Articles) {
        if ( Articles == null ) {
            return null;
        }

        List<ArticleDTO> list = new ArrayList<ArticleDTO>( Articles.size() );
        for ( Article article : Articles ) {
            list.add( toDTO( article ) );
        }

        return list;
    }

    @Override
    public Set<ArticleDTO> toDTOs(Set<Article> Articles) {
        if ( Articles == null ) {
            return null;
        }

        Set<ArticleDTO> set = new HashSet<ArticleDTO>( Math.max( (int) ( Articles.size() / .75f ) + 1, 16 ) );
        for ( Article article : Articles ) {
            set.add( toDTO( article ) );
        }

        return set;
    }
}
