package pl.eltrox.delivery.webapi;

import pl.eltrox.core.repositories.ArticleRepository;
import pl.eltrox.core.usecases.getarticle.GetArticleUseCase;
import pl.eltrox.data.repositories.JpaArticleRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Daniel Zawłocki
 * @date 2018/02/20
 */
public class UseCaseFactory {
    private static final EntityManagerFactory entityManagerFactory;
    private static final EntityManager entityManager;
    private static final ArticleRepository articleRepository;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        entityManager = entityManagerFactory.createEntityManager();
        articleRepository = new JpaArticleRepository(entityManager);
    }

    public static GetArticleUseCase getArticleUseCase() {
        return new GetArticleUseCase(articleRepository);
    }
}
