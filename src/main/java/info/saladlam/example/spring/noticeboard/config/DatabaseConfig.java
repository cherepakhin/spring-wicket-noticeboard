package info.saladlam.example.spring.noticeboard.config;

import javax.sql.DataSource;

import info.saladlam.example.spring.noticeboard.support.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DatabaseConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);

	@Bean
	@Profile("!test")
//	@Profile("test")
	public DataSource dataSource() {
		LOGGER.info("INIT DATABASE");
		return Helper.getEmbeddedDatabaseBuilder("noticeboard").build();
	}

}
