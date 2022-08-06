package pro.ayay.backend.gateway.service.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pro.ayay.backend.gateway.service.feign.AuthorizationClient;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {

  private final AuthorizationClient authorizationClient;
  private static final String AUTHORIZATION_HEADER = "Authorization";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    // token looks like `Bearer <token>`
    String authorization = request.getHeader(AUTHORIZATION_HEADER);
    try {
    Object o = authorizationClient.retrieveUser(authorization);
    } catch (Exception ex) {
      // 401 Unauthorized

    }
    // request.addHeader("X-User", o)
  }
}
