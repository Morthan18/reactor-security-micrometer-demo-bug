package com.example

import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/secured-hello")
    suspend fun helloSecured():String {
        return "hello secured"
    }

    @GetMapping("/public-hello")
    suspend fun hello() = "hello public"
}