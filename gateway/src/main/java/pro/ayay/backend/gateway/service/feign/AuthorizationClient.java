package pro.ayay.backend.gateway.service.feign;

import feign.codec.Decoder;
import lombok.Data;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import pro.ayay.backend.gateway.service.feign.AuthorizationClient.FeignResponseDecoderConfig;

@FeignClient(
    name = "Authorization-Client",
    url = "http://localhost:9001",
    configuration = FeignResponseDecoderConfig.class
)
public interface AuthorizationClient {

  @GetMapping("/api/v1/authorization/private/authentication")
  User retrieve(@RequestHeader(name = "Authorization") String token);

  @PostMapping("/api/v1/authorization/private/users")
  User save(@RequestBody User user);

  @Data
  class User {
    private String username;
    private String email;
  }

  public class FeignResponseDecoderConfig {
    @Bean
    public Decoder feignDecoder() {

      ObjectFactory<HttpMessageConverters> messageConverters = () -> {
        HttpMessageConverters converters = new HttpMessageConverters();
        return converters;
      };
      return new SpringDecoder(messageConverters);
    }
  }
}
