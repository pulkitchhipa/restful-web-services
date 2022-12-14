package com.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
public class UserResource {
  private  UserDaoService service;
  public UserResource(UserDaoService service) {
      this.service = service;
  }

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
      return service.findAll();
  }

  @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
      return service.findUserById(id);
  }

  @PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = service.save(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
    return ResponseEntity.created(location).build();
  }
}
