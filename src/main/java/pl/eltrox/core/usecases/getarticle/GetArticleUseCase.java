package pl.eltrox.core.usecases.getarticle;

import pl.eltrox.core.entities.Article;
import pl.eltrox.core.repositories.ArticleRepository;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public class GetArticleUseCase implements UseCase <GetArticleRequest, GetArticleResponse> {
    private ArticleRepository articleRepository;

    public GetArticleUseCase(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public GetArticleResponse execute(GetArticleRequest request) {
        Long articleId = request.getArticleId();
        Article article = articleRepository.get(articleId);
        GetArticleResponse response = new GetArticleResponse();
        response.setData(article);

        return response;
    }
}
