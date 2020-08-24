package com.okta.springboot.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
class TheController {
	@GetMapping("/", produces = [MediaType.TEXT_HTML_VALUE])
	fun theAnswer(): String = "<h1>Hello, World</h1>"
}
