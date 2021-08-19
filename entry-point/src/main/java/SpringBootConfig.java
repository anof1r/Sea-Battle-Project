/*
 * Copyright
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot config class.
 *
 * @since 0.0.1
 */
@SpringBootApplication(scanBasePackages = "seabattle")
@EnableJpaRepositories(basePackages = "seabattle.database")
@EntityScan(basePackages = "seabattle.database")
public class SpringBootConfig {
}
