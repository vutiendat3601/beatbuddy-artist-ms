package vn.io.vutiendat3601.beatbuddy.artist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ArtistServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArtistServiceApplication.class, args);
	}
}
