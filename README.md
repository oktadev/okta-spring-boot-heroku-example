# Spring Boot + Heroku Example

This example app shows how to build a simple Spring Boot app with Kotlin and deploy it to Heroku. Please read [Deploy a Secure Spring Boot App to Heroku][blog-post] to see how it was created.

**Prerequisites:**

- [Java 11](https://adoptopenjdk.net/)+
- A [Heroku account](https://signup.heroku.com/) 
- The [Heroku CLI][setup-heroku]

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage and secure users and roles in any application.

- [Getting Started](#getting-started)
- [Links](#links)
- [Help](#help)
- [License](#license)

## Getting Started

To install this application, run the following commands:

```bash
git clone https://github.com/oktadeveloper/okta-spring-boot-heroku-example.git
cd okta-spring-boot-heroku-example
```

### Use Okta for Authentication

To use Okta for authentication, log in to your Heroku account.

```
heroku login
```

Then, create a new app. 

```
heroku apps:create
```

Add the Okta Heroku Add-on. 

```
heroku addons:create okta
```

This add-on creates a user and configured Okta application for you. The configuration settings will be specified for your service via environment variables. You can lookup these settings with `heroku config`.

For OpenID Connect (OIDC) authentication and OAuth 2.0 authorization, only three variables are important to you: `OKTA_OAUTH2_ISSUER`, `OKTA_OAUTH2_CLIENT_ID_WEB`, and `OKTA_OAUTH2_CLIENT_SECRET_WEB`.

These are already configured in `src/main/resources/application.properties`.

```properties
okta.oauth2.issuer=${OKTA_OAUTH2_ISSUER}
okta.oauth2.clientId=${OKTA_OAUTH2_CLIENT_ID_WEB}
okta.oauth2.clientSecret=${OKTA_OAUTH2_CLIENT_SECRET_WEB}
```

Deploy your app to Heroku using Git.

```
git push heroku main
```

You can also run it locally using:

```
OKTA_OAUTH2_ISSUER=your-issuer-value \
 OKTA_OAUTH2_CLIENT_ID_WEB=your-client-id \
 OKTA_OAUTH2_CLIENT_SECRET_WEB=your-client-secret \
 ./gradlew bootRun
```

**TIP:** See the blog post to see [how to configure IntelliJ IDEA with these variables](https://developer.okta.com/blog/2020/08/31/spring-boot-heroku#configure-intellij-idea-to-run-your-spring-boot-app).

## Links

This example uses the following open source libraries, which is sponsored by Okta:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Okta Spring Boot Starter](https://github.com/okta/okta-spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)

## Help

Please post any questions as comments on the [blog post][blog-post], or visit our [Okta Developer Forums](https://devforum.okta.com/). You can also ask them on [Stack Overflow with the `okta` tag](https://stackoverflow.com/tags/okta).

## License

Apache 2.0, see [LICENSE](LICENSE).

[blog-post]: https://developer.okta.com/blog/2020/08/31/spring-boot-heroku
[setup-heroku]: https://devcenter.heroku.com/articles/heroku-cli
