package agb1986.lnd;

import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import agb1986.lnd.configs.GreetingConfig;
import agb1986.lnd.services.GreetingService;

@Path("/quarkus")
public class GreetingResource {
    @Inject
    GreetingConfig greetingConfig;

    private final GreetingService greetingService;

    private final String url;

    public GreetingResource(GreetingService greetingService,
            @ConfigProperty(name = "application.host") Optional<String> url) {
        this.greetingService = greetingService;
        this.url = url.orElse("http://localhost:8100");
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return this.greetingService.getGreeting();
    }

    @GET
    @Path("/url")
    @Produces(MediaType.TEXT_PLAIN)
    public String url() {
        return this.url;
    }

    @GET
    @Path("/config")
    @Produces(MediaType.TEXT_PLAIN)
    public String config() {
        return greetingConfig.getMessage() + greetingConfig.getName() + greetingConfig.getSuffix()
                + greetingConfig.getContentConfig().getPrizeAmount()
                + greetingConfig.getContentConfig().getRecipients();
    }
}
