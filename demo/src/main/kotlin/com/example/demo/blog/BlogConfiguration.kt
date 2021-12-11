package com.example.demo.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepositoriy) =
        ApplicationRunner{
            val user = userRepository.save(User("login", "firstName", "lastName"))
            articleRepository.save(Article("title1", "headline1", "content1", user))
            articleRepository.save(Article("title2", "headline2", "content2", user))
        }
}