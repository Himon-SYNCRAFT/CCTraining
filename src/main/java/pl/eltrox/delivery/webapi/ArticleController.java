package pl.eltrox.delivery.webapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.eltrox.core.entities.Article;
import pl.eltrox.core.usecases.getarticle.GetArticleRequest;
import pl.eltrox.core.usecases.getarticle.GetArticleResponse;
import pl.eltrox.core.usecases.getarticle.GetArticleUseCase;

/**
 * @author Daniel Zawłocki
 * @date 2018/02/19
 */

@RestController
public class ArticleController {
    @RequestMapping("/article/{id}")
    public Article getArticle(@PathVariable(value = "id") Long id) {
        GetArticleUseCase useCase = UseCaseFactory.getArticleUseCase();
        GetArticleRequest request = new GetArticleRequest(id);
        GetArticleResponse response = useCase.execute(request);

        return response.getData();
    }
}
