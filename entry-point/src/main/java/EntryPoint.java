/*
 * Copyright
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Entry point for launch spring boot.
 *
 * @since 0.0.1
 */
public class EntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntryPoint.class);

    /**
     * Entry point.
     * @param args Arguments.
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    public static void main(final String[] args)  {
        SpringApplication.run(SpringBootConfig.class, args);
        LOGGER.trace("Application started.");
    }
}

