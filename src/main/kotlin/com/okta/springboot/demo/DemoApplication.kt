package com.okta.springboot.demo

import indexPage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser
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
	fun theAnswer(@AuthenticationPrincipal user: OidcUser?): String = indexPage(user)
}
