package com.odmytrenko.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "providers")
@Data
public class ProvidersProperties {

    private Map<String, String> finance = new HashMap<>();
    private Map<String, String> kurs = new HashMap<>();
}
