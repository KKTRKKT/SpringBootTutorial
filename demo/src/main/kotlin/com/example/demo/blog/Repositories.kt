package com.example.demo.blog

import org.springframework.data.repository.CrudRepository

interface ArticleRepositoriy: CrudRepository<Article, Long> {
    fun findBySlug(slug: String) : Article?
    fun findAllByOrderByAddedAtDesc() : Iterable<Article>
}

interface UserRepository: CrudRepository<User, Long>{
    fun findByLogin(login: String) : User?
}