package pro.ayay.backend.gateway.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
    name = "Authorization-Client",
    url = "${ayay.services.authorization-client}"
)
public interface AuthorizationClient {

  @GetMapping("/api/v1/authorization/private/authentication")
  public Object retrieveUser(@RequestHeader(name = "Authorization") String token);
}
