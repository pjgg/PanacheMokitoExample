package org.acme;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.anyString;

@QuarkusTest
public class FruitResourceTest {

    @Test
    public void blackboxTestingExample() {
        given()
          .when().get("/fruit?name=orange")
          .then()
             .statusCode(204);
    }

    @Test
    public void whiteBoxTestingExample() {
        PanacheMock.mock(Fruit.class);

        given()
                .when().get("/fruit?name=orange")
                .then()
                .statusCode(204);

        PanacheMock.verify(Fruit.class, Mockito.times(1)).findByName(anyString());
    }
}