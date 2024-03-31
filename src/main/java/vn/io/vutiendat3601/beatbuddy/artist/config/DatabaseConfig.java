package vn.io.vutiendat3601.beatbuddy.artist.config;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;

@Configuration
public class DatabaseConfig {
    @Bean
    DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    };
}
