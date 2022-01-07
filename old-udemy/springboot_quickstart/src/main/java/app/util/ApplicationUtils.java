package app.util;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ApplicationUtils {
    public String generateUserId() {
        return UUID.randomUUID().toString();
    }
}
