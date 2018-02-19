package pl.eltrox.core.usecases.getarticlesincategory;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public class GetArticlesInCategoryRequest {
    private final Long categoryId;

    public GetArticlesInCategoryRequest(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
