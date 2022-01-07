package app.services;

import app.models.UserDetails;
import app.models.UserRest;

public interface UserService {
    UserRest createUser(UserDetails userDetails);
}
