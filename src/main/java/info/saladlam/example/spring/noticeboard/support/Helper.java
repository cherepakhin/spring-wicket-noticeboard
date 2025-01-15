package info.saladlam.example.spring.noticeboard.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public abstract class Helper {

	private static final Logger log = LoggerFactory.getLogger(Helper.class);

	private Helper() {
		throw new IllegalStateException("Can't create instance of utility class");
	}

	public static EmbeddedDatabase getEmbeddedDatabase(String name, String ... addScripts) {
		EmbeddedDatabaseBuilder db = Helper.getEmbeddedDatabaseBuilder(name)
			.setScriptEncoding("UTF-8")
			.addScript("classpath:/sql/dbschema.sql");
		log.info("getEmbeddedDatabase %s", name);
		for (String script : addScripts) {
			db.addScript(script);
		}
		return db.build();
	}

	public static EmbeddedDatabaseBuilder getEmbeddedDatabaseBuilder(String name) {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.setName(name);
	}

}
