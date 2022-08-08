# Example

```
(service)
@GetMapping("/api/v1/login")
public String login(@RequestParam String username) {}

(feign)
@FeignClient(
    ...
)
public interface <name> {

    @GetMapping("/api/v1/login")
    String login(@RequestParam String username);
}
```
