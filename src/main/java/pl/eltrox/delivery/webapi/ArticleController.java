package pl.eltrox.delivery.webapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.eltrox.core.entities.Article;
import pl.eltrox.core.repositories.ArticleRepository;
import pl.eltrox.core.usecases.getarticle.GetArticleRequest;
import pl.eltrox.core.usecases.getarticle.GetArticleResponse;
import pl.eltrox.core.usecases.getarticle.GetArticleUseCase;
import pl.eltrox.data.repositories.JpaArticleRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Daniel Zawłocki
 * @date 2018/02/19
 */

@RestController
public class ArticleController {
    public static EntityManagerFactory entityManagerFactory;
    public static EntityManager entityManager;

    @RequestMapping("/article/{id}")
    public Article getArticle(@PathVariable(value = "id") Long id) {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        entityManager = entityManagerFactory.createEntityManager();

        ArticleRepository articleRepository = new JpaArticleRepository(entityManager);
        GetArticleUseCase useCase = new GetArticleUseCase(articleRepository);
        GetArticleRequest request = new GetArticleRequest(id);
        GetArticleResponse response = useCase.execute(request);

        return response.getData();
    }
}
