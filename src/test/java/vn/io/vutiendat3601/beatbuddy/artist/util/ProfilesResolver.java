package vn.io.vutiendat3601.beatbuddy.artist.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.ActiveProfilesResolver;

@Slf4j
public class ProfilesResolver implements ActiveProfilesResolver {
  @Override
  public String[] resolve(Class<?> testClass) {
    String profile = System.getProperty("spring.profiles.active", "dev");
    log.info("Active profile via spring.profiles.active: {}", profile);
    return new String[] {profile};
  }
}
