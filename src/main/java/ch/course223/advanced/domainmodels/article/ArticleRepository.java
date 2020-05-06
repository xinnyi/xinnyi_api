package ch.course223.advanced.domainmodels.article;

import ch.course223.advanced.core.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ExtendedJpaRepository<Article> {
}
