package pl.eltrox.core.usecases.getarticlesincategory;

import pl.eltrox.core.entities.Article;
import pl.eltrox.core.repositories.ArticleRepository;
import pl.eltrox.core.usecases.UseCase;

import java.util.List;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public class GetArticlesInCategoryUseCase implements UseCase<GetArticlesInCategoryRequest, GetArticlesInCategoryResponse> {
    private ArticleRepository articleRepository;

    public GetArticlesInCategoryUseCase(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public GetArticlesInCategoryResponse execute(GetArticlesInCategoryRequest request) {
        Long categoryId = request.getCategoryId();
        List<Article> articles = articleRepository.getByCategory(categoryId);

        GetArticlesInCategoryResponse response = new GetArticlesInCategoryResponse();
        response.setData(articles);

        return response;
    }
}
