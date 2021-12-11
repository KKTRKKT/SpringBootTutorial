package com.example.demo.blog

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/articles")
class ArticleController (private val repositoriy: ArticleRepositoriy) {

    @GetMapping("/")
    fun findAll() = repositoriy.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug : String) =
        repositoriy.findBySlug(slug)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "this article does not exist")
}

@RestController
@RequestMapping("/api/users")
class UserController(private val repositoriy: UserRepository){
    @GetMapping("/")
    fun findAll() = repositoriy.findAll();

    @GetMapping("/{login}")
    fun findOne(@PathVariable login: String) =
        repositoriy.findByLogin(login)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "this user does not exist")
}