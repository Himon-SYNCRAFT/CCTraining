package usecases

import pl.eltrox.core.entities.Article
import pl.eltrox.core.entities.Category
import pl.eltrox.core.repositories.ArticleRepository
import pl.eltrox.core.usecases.getarticlesincategory.GetArticlesInCategoryRequest
import pl.eltrox.core.usecases.getarticlesincategory.GetArticlesInCategoryUseCase
import spock.lang.Specification

class GetArticlesInCategory extends Specification {
    private ArticleRepository articleRepository

    def setup() {
        articleRepository = Mock(ArticleRepository)
        def articles = new ArrayList<Article>()

        def category = new Category()
        category.setId(1L)
        category.setName("Category1")

        def article = new Article()
        article.setName("product1")
        article.setId(1L)
        article.setSku("1")
        article.setCategory(category)
        articles.add(article)

        article = new Article()
        article.setName("product2")
        article.setId(2L)
        article.setSku("2")
        article.setCategory(category)
        articles.add(article)

        article = new Article()
        article.setName("product3")
        article.setId(3L)
        article.setSku("3")
        article.setCategory(category)
        articles.add(article)

        articleRepository.getByCategory(1L) >> articles
    }

    def "GetArticlesInCategory.execute() should return response with articles in category identified by given categoryId"() {
        given: "UseCase under test"
        def useCase = new GetArticlesInCategoryUseCase(articleRepository)

        and: "valid request with categoryId"
        def categoryId = 1L
        def request = new GetArticlesInCategoryRequest(categoryId)

        when: "we execute use case"
        def response = useCase.execute(request)

        then: "we get response with list of articles in requested category"
        def articles = response.getData()
        articles.size() == 3
        articles.each {
            it.getCategory().getId() == categoryId
        }
    }
}
