package pl.eltrox.core.usecases;

public interface UseCase <Request, Response> {
    Response execute(Request request);
}
