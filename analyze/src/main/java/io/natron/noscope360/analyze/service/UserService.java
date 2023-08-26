package io.natron.noscope360.analyze.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static io.natron.noscope360.analyze.config.UserRole.ADMIN;

/**
 * Service class responsible for managing user authentication and loading
 * user-specific data for the Spring Security framework.
 */
@Service
public class UserService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    /**
     * The encoder to hash passwords.
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * The administrator's username, typically loaded from application properties.
     */
    @Value("${admin.security.username}")
    private String adminUsername;

    /**
     * The administrator's password, typically loaded from application properties.
     */
    @Value("${admin.security.password}")
    private String adminPassword;

    /**
     * Constructs a new UserService instance with the provided password encoder.
     *
     * @param passwordEncoder The password encoder.
     */
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Loads a user by the username. In this implementation, only an admin user is
     * recognized and loaded based on the given username. The method will throw an exception
     * if the provided username does not match the configured admin username.
     *
     * @param username The username to be loaded.
     * @return UserDetails The details of the loaded user.
     * @throws UsernameNotFoundException if the username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user {}", username);
        if (username.equals(adminUsername)) {
            String password = passwordEncoder.encode(adminPassword);
            return User.withUsername(adminUsername).password(password).roles(ADMIN).build();
        }
        throw new UsernameNotFoundException("Username " + username + " not found");
    }
}
