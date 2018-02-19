package usecases

import pl.eltrox.core.entities.Article
import pl.eltrox.core.repositories.ArticleRepository
import pl.eltrox.core.usecases.getarticle.GetArticleRequest
import pl.eltrox.core.usecases.getarticle.GetArticleUseCase
import spock.lang.Specification

class GetArticleUseCaseSpec extends Specification {
    private ArticleRepository articleRepository

    def setup() {
        articleRepository = Mock(ArticleRepository)
        def article = new Article()
        def articleId = 1L

        article.setSku("1234")
        article.setId(articleId)
        article.setName("Produckt")

        articleRepository.get(articleId) >> article
    }

    def "GetArticleUseCaseSpec.execute() should return Article identified by given id"() {
        given: "UseCase under test"
        def useCase = new GetArticleUseCase(articleRepository)

        and: "valid request with articleId"
        Long articleId = 1
        def request = new GetArticleRequest(articleId)

        when: "we try to execute useCase"
        def response = useCase.execute(request)

        then: "we get successfull response with requested id"
        def article = response.getData()
        article.getId() == articleId
    }
}
