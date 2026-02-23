package fmfi.sbdemo;

import org.springframework.boot.context.properties.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("app.hello")
public record HelloConfigProperties(
    @DefaultValue("Hello") String greeting
) { }
