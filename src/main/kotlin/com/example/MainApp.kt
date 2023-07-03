package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.core.publisher.Hooks

@SpringBootApplication
open class MainApp

fun main(args: Array<String>) {
    Hooks.enableAutomaticContextPropagation()
    runApplication<MainApp>(*args)
}