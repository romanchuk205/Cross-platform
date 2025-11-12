package org.romanchuk;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.annotation.security.RolesAllowed; // <--- ДОДАЙ ЦЕЙ ІМПОРТ

@Path("/hello")
public class GreetingResource {

    // Публічна, незахищена кінцева точка (як була в Лабі 1)
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    // НОВА, захищена кінцева точка (для Лаби 2)
    @GET
    @Path("/secure") // Новий шлях: /hello/secure
    @RolesAllowed("User") // ЗАХИСТ: доступ дозволено лише користувачам з роллю "User"
    @Produces(MediaType.TEXT_PLAIN)
    public String secureHello() {
        return "Hello, secured user! Your OIDC protection works.";
    }
}