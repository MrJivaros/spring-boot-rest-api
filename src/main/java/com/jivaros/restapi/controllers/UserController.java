package com.jivaros.restapi.controllers;

import java.util.Optional;

import com.jivaros.restapi.models.User;
import com.jivaros.restapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public Iterable<User> findAll() {
    return this.userRepository.findAll();
  }

  @PostMapping
  public User create(@RequestBody User user) {
    return this.userRepository.save(user);
  }

  @GetMapping("/{id}")
  public Optional<User> findOne(@PathVariable(value = "id") long id) {
    Optional<User> user = this.userRepository.findById(id);
    if (user.isPresent()) {
      return user;
    } else {
      throw new Error("can't find user");
    }
  }

}
