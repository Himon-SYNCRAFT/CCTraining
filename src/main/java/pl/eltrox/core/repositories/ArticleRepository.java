package pl.eltrox.core.repositories;

import pl.eltrox.core.entities.Article;

import java.util.List;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public interface ArticleRepository {
    Article get(Long id);
    List<Article> getByCategory(Long id);
}
