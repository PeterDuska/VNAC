package fmfi.sbdemo.adapter.integration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClient;

@Configuration // Indicates that a class declares one or more @Bean methods
@lombok.RequiredArgsConstructor
public class IntegrationAdapterConfiguration {

  private final IntegrationFeesConfigProperties feesConfigProperties;

  @Bean // Indicates that a method produces a bean to be managed by the Spring container
  RestClient feesRestTemplate() {
    return RestClient.builder()
        .baseUrl(feesConfigProperties.baseUri())
        .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + feesConfigProperties.encodedBasicAuth())
        .build();
  }

  @ConfigurationProperties("app.integration.fees")
  public record IntegrationFeesConfigProperties(
      String baseUri,
      String username,
      String password
  ) {
    String encodedBasicAuth() {
      return HttpHeaders.encodeBasicAuth(username, password, /* charset */ null);
    }
  }
}
