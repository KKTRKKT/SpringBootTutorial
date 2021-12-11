package com.example.demo

import com.example.demo.blog.Article
import com.example.demo.blog.ArticleRepositoriy
import com.example.demo.blog.User
import com.example.demo.blog.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor (
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepositoriy: ArticleRepositoriy
        ) {
    @Test
    fun `When findByIdOrNull then return  Article`(){
        val user = User("login", "firstname", "lastname")
        entityManager.persist(user)
        val article = Article("title", "headline", "content", user)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepositoriy.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val user = User("login", "firstname", "lastname")
        entityManager.persist(user)
        entityManager.flush()
        val found = userRepository.findByLogin(user.login)
        assertThat(found).isEqualTo(user)
    }
}