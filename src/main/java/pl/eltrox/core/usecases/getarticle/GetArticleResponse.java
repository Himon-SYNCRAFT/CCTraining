package pl.eltrox.core.usecases.getarticle;

import pl.eltrox.core.entities.Article;
import pl.eltrox.core.usecases.Response;

import java.util.List;

/**
 * @author Daniel Zawlocki
 * @date 2018/02/19
 */
public class GetArticleResponse implements Response <Article> {
    private Article data;
    private List<String> errors;

    public Article getData() {
        return data;
    }

    public void setData(Article data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public void addError(String error) {
        errors.add(error);
    }
}
