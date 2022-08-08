package pro.ayay.backend.gateway.service;

import java.util.List;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import pro.ayay.backend.gateway.service.TokenGatewayFilterFactory.Config;
import pro.ayay.backend.gateway.service.feign.AuthorizationService;

@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<Config> {

  private final AuthorizationService authorizationService;

  public TokenGatewayFilterFactory(@Lazy AuthorizationService authorizationService) {
    super(Config.class);
    this.authorizationService = authorizationService;
  }

  @Override
  public GatewayFilter apply(Config config) {
    return (exchange, chain) -> {
      List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
      String token = authorization.get(0);
      String username = authorizationService.getUsername(token);

      ServerHttpRequest request = exchange.getRequest().mutate().header("X-User", username).build();
      ServerWebExchange result = exchange.mutate().request(request).build();
      return chain.filter(result);
    };
  }

  public static class Config {

  }
}
