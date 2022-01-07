package agb1986.lnd.configs;

import java.util.List;
import javax.validation.constraints.Positive;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "greeting")
public interface GreetingConfig {

    @WithName("message")
    String getMessage();

    @WithName("suffix")
    @WithDefault("!")
    String getSuffix();

    @WithName("name")
    String getName();

    @WithName("content")
    ContentConfig getContentConfig();

    interface ContentConfig {

        @Positive
        @WithName("prizeAmount")
        Integer getPrizeAmount();

        @WithName("recipients")
        List<String> getRecipients();
    }
}
