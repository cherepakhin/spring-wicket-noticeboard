package info.saladlam.example.spring.noticeboard.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import static java.lang.String.format;

public abstract class Helper {

	private static final Logger log = LoggerFactory.getLogger(Helper.class);

	private Helper() {
		throw new IllegalStateException("Can't create instance of utility class");
	}

	public static EmbeddedDatabase getEmbeddedDatabase(String name, String ... addScripts) {
		EmbeddedDatabaseBuilder db = Helper.getEmbeddedDatabaseBuilder(name)
			.setScriptEncoding("UTF-8")
			.addScript("classpath:/sql/dbschema.sql");
		log.info("EmbeddedDatabase.getEmbeddedDatabase name={}", name);
		log.info("EmbeddedDatabase.getEmbeddedDatabase addScripts");
		for (String script :addScripts ) {
			log.info("EmbeddedDatabase scripts={}", script);
		}
		for (String script : addScripts) {
			db.addScript(script);
		}
		return db.build();
	}

	public static EmbeddedDatabaseBuilder getEmbeddedDatabaseBuilder(String name) {
		log.info(format("getEmbeddedDatabaseBuilder %s", name));
		log.info("EmbeddedDatabase name={}", name);
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.setName(name);
	}

}
