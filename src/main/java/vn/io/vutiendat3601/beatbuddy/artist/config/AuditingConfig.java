package vn.io.vutiendat3601.beatbuddy.artist.config;

import static vn.io.vutiendat3601.beatbuddy.artist.util.UserContext.ANONYMOUS;
import static vn.io.vutiendat3601.beatbuddy.artist.util.UserContext.AUTH_ID_HEADER;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import reactor.core.publisher.Mono;

@Configuration
@EnableR2dbcAuditing(auditorAwareRef = "authIdAuditAware", dateTimeProviderRef = "zoneDateTimeProvider")
public class AuditingConfig {
    @Bean
    ReactiveAuditorAware<String> authIdAuditAware() {
        return () -> Mono.deferContextual(ctx -> Mono
                .just(ctx.<String>getOrDefault(AUTH_ID_HEADER, ANONYMOUS))

        );
    }

    @Bean
    DateTimeProvider zoneDateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    };
}
