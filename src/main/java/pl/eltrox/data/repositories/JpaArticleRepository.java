package pl.eltrox.data.repositories;

import pl.eltrox.core.entities.Article;
import pl.eltrox.core.entities.Category;
import pl.eltrox.core.repositories.ArticleRepository;
import pl.eltrox.data.entities.ArticleEntity;
import pl.eltrox.data.entities.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Zawłocki
 * @date 2018/02/19
 */
public class JpaArticleRepository implements ArticleRepository {
    private EntityManager entityManager;

    public JpaArticleRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Article get(Long id) {
        ArticleEntity articleEntity = entityManager.find(ArticleEntity.class, id);
        return toDomainModel(articleEntity);
    }

    @Override
    public List<Article> getByCategory(Long id) {
        TypedQuery<ArticleEntity> query = entityManager.createQuery(
                "SELECT a FROM Article a WHERE a.category_id = :category_id",
                ArticleEntity.class
        );

        query.setParameter("category_id", id);
        List<ArticleEntity> articleEntities = query.getResultList();

        List<Article> articles = new ArrayList<>();

        for (ArticleEntity articleEntity : articleEntities) {
            articles.add(toDomainModel(articleEntity));
        }

        return articles;
    }

    private Article toDomainModel(ArticleEntity articleEntity) {
        CategoryEntity categoryEntity = articleEntity.getCategory();

        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());

        Article article = new Article();
        article.setId(articleEntity.getId());
        article.setName(articleEntity.getName());
        article.setSku(articleEntity.getSku());
        article.setCategory(category);

        return article;
    }
}
