import kotlinx.html.*
import kotlinx.html.stream.createHTML
import org.springframework.security.oauth2.core.oidc.user.OidcUser

fun indexPage(user: OidcUser?) = createHTML().html {
    head {
        link("https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css", rel = "stylesheet")
    }
    body("h-100") {
        div("container lead text-center") {
            div("h-100 align-items-center") {
                style = "display: grid"
                div("jumbotron jumbotron-fluid") {
                    // choose the right view depending on login status
                    if (user == null) guestView()
                    else enlightenedUserView(user)
                }
            }
        }
    }
}

private fun FlowContent.enlightenedUserView(user: OidcUser) {
    h1 { +"Hello, ${user.fullName}" }
    p {
        +"The answer you were looking for is"
        h1("badge-dark display-1") {
            +"42"
        }
    }
    hr {  }
    p("text-right text-muted small") {
        +"Your email ${user.email} is ${"not".takeIf { !user.emailVerified }.orEmpty()} verified"
    }
}

private fun FlowContent.guestView() {
    h1 { +"Hello, Guest" }
    a(href = "/oauth2/authorization/okta") {
        +"Login to get The Answer"
    }
}
