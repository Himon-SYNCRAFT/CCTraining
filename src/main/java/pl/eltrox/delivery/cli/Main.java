package pl.eltrox.delivery.cli;

import pl.eltrox.core.entities.Article;
import pl.eltrox.core.repositories.ArticleRepository;
import pl.eltrox.data.entities.ArticleEntity;
import pl.eltrox.data.entities.CategoryEntity;
import pl.eltrox.data.repositories.JpaArticleRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Daniel Zawłocki
 * @date 2018/02/19
 */
public class Main {
    public static EntityManagerFactory entityManagerFactory;
    public static EntityManager entityManager;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        entityManager = entityManagerFactory.createEntityManager();

        CategoryEntity category = new CategoryEntity();
        category.setName("main");

        ArticleEntity article = new ArticleEntity();
        article.setCategory(category);
        article.setName("article1");
        article.setSku("1234");

        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.persist(article);
        entityManager.getTransaction().commit();

        ArticleRepository articleRepository = new JpaArticleRepository(entityManager);
        Article article1 = articleRepository.get(article.getId());
        System.out.println(article1.getName());

        entityManager.close();
        entityManagerFactory.close();
    }
}
