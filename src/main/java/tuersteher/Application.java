package tuersteher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Collections;

/**
 * @author Robert Rabe on 20.03.20.
 */
@EnableCaching
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        String port = System.getenv("PORT");
        if (port == null) {
            port = "8080";
        }
        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        app.run(args);
    }
}
