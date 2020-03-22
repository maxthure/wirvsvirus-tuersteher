package tuersteher.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Robert Rabe on 21.03.20.
 */
// Adapted from https://devcenter.heroku.com/articles/heroku-postgresql#connecting-in-java
@Configuration
public class MainConfig {

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(dbUrl);
        builder.password(password);
        builder.username(username);
        return builder.build();
    }
}