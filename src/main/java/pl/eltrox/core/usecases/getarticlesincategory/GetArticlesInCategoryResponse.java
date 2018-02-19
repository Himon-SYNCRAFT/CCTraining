package pl.eltrox.core.usecases.getarticlesincategory;

import pl.eltrox.core.entities.Article;
import pl.eltrox.core.usecases.Response;

import java.util.List;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public class GetArticlesInCategoryResponse implements Response<List<Article>> {
    private List<Article> data;
    private List<String> errors;

    @Override
    public List<Article> getData() {
        return data;
    }

    @Override
    public void setData(List<Article> data) {
        this.data = data;
    }

    @Override
    public void addError(String error) {
        errors.add(error);
    }

    @Override
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public List<String> getErrors() {
        return errors;
    }
}
