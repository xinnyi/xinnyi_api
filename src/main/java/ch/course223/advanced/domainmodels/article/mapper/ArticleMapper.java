package ch.course223.advanced.domainmodels.article.mapper;

import ch.course223.advanced.core.ExtendedDTOMapper;
import ch.course223.advanced.domainmodels.article.Article;
import ch.course223.advanced.domainmodels.article.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface ArticleMapper extends ExtendedDTOMapper<Article, ArticleDTO> {
}
