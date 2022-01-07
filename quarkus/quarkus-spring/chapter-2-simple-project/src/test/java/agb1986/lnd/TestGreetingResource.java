package agb1986.lnd;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import agb1986.lnd.services.GreetingService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
class TestGreetingResource {

    @InjectMock
    GreetingService greetingService;

    @Test
    void testHelloEndpoint() {
        Mockito.when(this.greetingService.getGreeting()).thenReturn("Hello Quarkus");
        given().when().get("/quarkus/hello").then().statusCode(200).body(is("Hello Quarkus"));
        Mockito.verify(this.greetingService).getGreeting();
        Mockito.verifyNoMoreInteractions(this.greetingService);
    }
}
