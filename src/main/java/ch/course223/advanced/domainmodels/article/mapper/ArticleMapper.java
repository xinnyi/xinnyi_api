package ch.course223.advanced.domainmodels.article.mapper;

import ch.course223.advanced.domainmodels.article.Article;
import ch.course223.advanced.domainmodels.article.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper{
    Article fromDTO(ArticleDTO dto);

    List<Article> fromDTOs(List<ArticleDTO> dtos);

    Set<Article> fromDTOs(Set<ArticleDTO> dtos);

    ArticleDTO toDTO(Article Article);

    List<ArticleDTO> toDTOs(List<Article> Articles);

    Set<ArticleDTO> toDTOs(Set<Article> Articles);
}