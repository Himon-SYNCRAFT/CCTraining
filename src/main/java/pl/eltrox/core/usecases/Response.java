package pl.eltrox.core.usecases;

import java.util.List;

public interface Response <T> {
    T getData();
    List<String> getErrors();
    void setData(T data);
    void addError(String error);
    void setErrors(List<String> errors);
}
