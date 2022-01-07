package app.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.models.UserDetails;
import app.models.UserRest;
import app.util.ApplicationUtils;

@Service
public class UserServiceImp implements UserService {
    Map<String, UserRest> users;
    ApplicationUtils applicationUtils;

    @Autowired
    public UserServiceImp(ApplicationUtils applicationUtils) {
        this.applicationUtils = applicationUtils;
    }

    @Override
    public UserRest createUser(UserDetails userDetails) {
        UserRest userRest = new UserRest();

        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());
        userRest.setEmail(userDetails.getEmail());

        String userId = applicationUtils.generateUserId();

        if (users == null) {
            users = new HashMap<>();
        }
        userRest.setUserId(userId);
        users.put(userId, userRest);

        return userRest;
    }

}
