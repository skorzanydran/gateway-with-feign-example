package pro.ayay.backend.authorization.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.ayay.backend.authorization.controller.AuthInnerController.User;

@RestController
@RequestMapping("/api/v1/authorization/private/users")
public class UsersInnerController {

  @PostMapping
  public ResponseEntity<User> save(@RequestBody User user) {
    System.out.println("Saving user: " + user.toString());
    return ResponseEntity.ok(user);
  }
}
