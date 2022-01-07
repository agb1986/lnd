package agb1986.lnd;

import io.quarkus.test.junit.NativeImageTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

@NativeImageTest
class NativeGreetingResourceIT extends TestGreetingService {

    @Test
    void testHelloEndpointNative() {
        given().when().get("/quarkus/hello").then().statusCode(200)
                .body(is("Hello Quarkus for Spring Developer (prod)"));
    }
}
