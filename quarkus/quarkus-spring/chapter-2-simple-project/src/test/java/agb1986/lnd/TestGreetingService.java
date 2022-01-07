package agb1986.lnd;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import agb1986.lnd.services.GreetingService;

class TestGreetingService {

    @Test
    void test_getGreeting_Positive() {
        Optional<String> greetingMessage = Optional.of("Quarkus");
        Assertions.assertEquals("Hello Quarkus",
                new GreetingService(greetingMessage).getGreeting());
    }
}
