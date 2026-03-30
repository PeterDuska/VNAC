package sk.fmfi;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AdvancedGreetingResourceTest {
    @Test
    void testGreetingEndpointWithDefault() {
        given()
          .when().get("/greeting")
          .then()
             .statusCode(200)
             .body(is("Hello, World"));
    }

    @Test
    void testGreetingEndpointWithParam() {
        given()
            .when().get("/greeting?subject=FMFI")
            .then()
                .statusCode(200)
                .body(is("Hello, FMFI"));
    }

}