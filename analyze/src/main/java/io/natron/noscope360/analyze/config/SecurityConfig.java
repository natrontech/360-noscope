package io.natron.noscope360.analyze.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static io.natron.noscope360.analyze.config.UserRole.ADMIN;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Provides the main security configuration for the application. It encompasses
 * both API security settings (via Spring Security) and API documentation security settings
 * (via OpenAPI).
 */
@Configuration
public class SecurityConfig {

    /**
     * Constructs and configures the main security settings for the application.
     * This includes setting up basic authentication, disabling CSRF, and
     * defining role-based access controls.
     *
     * @param http The HttpSecurity object used to build and configure security settings.
     * @return SecurityFilterChain that contains the constructed security settings.
     * @throws Exception If an error occurs during the configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers(HttpMethod.GET, "/scale/**").hasRole(ADMIN)
                .anyRequest().permitAll());
        http.sessionManagement((sessionManager) -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

    /**
     * Provides the password encoder bean used to hash passwords in the system.
     * The BCrypt algorithm is utilized for this encoder.
     *
     * @return PasswordEncoder instance configured to use BCrypt.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the OpenAPI documentation settings, including setting up
     * security schemes and providing details about the API (title, version, description).
     *
     * @return OpenAPI object containing API documentation settings.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicAuth",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info().title("360-Noscope Analyzer").version("1.0")
                        .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }
}
