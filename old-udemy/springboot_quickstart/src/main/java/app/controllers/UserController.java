package app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.models.UserDetails;
import app.models.UserRest;
import app.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    Map<String, UserRest> users;
    
    @Autowired
    UserService userService;

    @GetMapping(path = "{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "limit", defaultValue = "50", required = false) int limit) {
        return "GET /users was called with pages " + page + " and limits " + limit;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetails userDetails) {
        return new ResponseEntity<UserRest>(userService.createUser(userDetails), HttpStatus.OK);
    }

    @PutMapping(path = "{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @RequestBody UserDetails userDetails) {
        if (users.containsKey(userId)) {
            users.get(userId).setFirstName(userDetails.getFirstName());
            users.get(userId).setLastName(userDetails.getLastName());
            users.get(userId).setEmail(userDetails.getEmail());
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(path = "{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserRest> deleteUser(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }
}
