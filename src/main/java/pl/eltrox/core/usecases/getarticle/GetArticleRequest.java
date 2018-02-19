package pl.eltrox.core.usecases.getarticle;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public class GetArticleRequest {
    private final Long articleId;

    public GetArticleRequest(Long articleId) {
        this.articleId = articleId;
    }

    public Long getArticleId() {
        return articleId;
    }
}
