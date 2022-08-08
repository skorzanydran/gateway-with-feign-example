package pro.ayay.backend.authorization.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authorization/private/authentication")
public class AuthInnerController {

  @GetMapping
  public ResponseEntity<?> retrieveUser(@RequestHeader(name = "Authorization") String token) {
    if ("BearerToken".equals(token)) {
      return ResponseEntity.ok(new User());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Data
  public static class User {
    private String username = "test_user";
    private String email = "email@ayay.pro";
  }
}
