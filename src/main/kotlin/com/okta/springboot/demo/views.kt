import kotlinx.html.*
import kotlinx.html.stream.createHTML

fun indexPage() = createHTML().html {
    head {
        link("https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css", rel = "stylesheet")
    }
    body("h-100") {
        div("container lead text-center") {
            div("h-100 align-items-center") {
                style = "display: grid"
                div("jumbotron jumbotron-fluid") {
                    // meaningful content goes here
                    guestView()
                }
            }
        }
    }
}

private fun FlowContent.guestView() {
    h1 { +"Hello, Guest" }
}
