package pro.ayay.backend.authorization.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authorization/open/authentication")
public class AuthController {

  @PostMapping
  public ResponseEntity<String> login() {
    return ResponseEntity.ok("BearerToken");
  }
}
