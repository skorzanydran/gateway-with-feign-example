package pro.ayay.backend.authorization.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authorization/public/users")
public class UserController {

  @GetMapping
  public ResponseEntity<String> whoami(@RequestHeader(name = "X-User") String username) {
    return ResponseEntity.ok(username);
  }
}
