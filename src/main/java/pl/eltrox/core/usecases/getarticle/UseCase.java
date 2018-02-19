package pl.eltrox.core.usecases.getarticle;

public interface UseCase <Request, Response> {
    Response execute(Request request);
}
