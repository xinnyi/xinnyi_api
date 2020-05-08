package ch.course223.advanced.domainmodels.article.mapper;

import ch.course223.advanced.domainmodels.article.Article;
import ch.course223.advanced.domainmodels.article.ArticleURLDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleURLMapper{
  Article fromDTO(ArticleURLDTO dto);

  List<Article> fromDTOs(List<ArticleURLDTO> dtos);

  Set<Article> fromDTOs(Set<ArticleURLDTO> dtos);

  ArticleURLDTO toDTO(Article Article);

  List<ArticleURLDTO> toDTOs(List<Article> Articles);

  Set<ArticleURLDTO> toDTOs(Set<Article> Articles);
}