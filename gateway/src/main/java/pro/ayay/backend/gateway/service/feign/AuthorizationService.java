package pro.ayay.backend.gateway.service.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.ayay.backend.gateway.service.feign.AuthorizationClient.User;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

  private final AuthorizationClient authorizationClient;

  public String getUsername(String token) {
    return authorizationClient.retrieve(token).getUsername();
  }

  public User save(User user) {
    return authorizationClient.save(user);
  }
}
