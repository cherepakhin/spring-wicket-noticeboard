package info.saladlam.example.spring.noticeboard.test;

import info.saladlam.example.spring.noticeboard.support.Helper;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HelperTest {

    @Test
    public void getEmbeddedDatabaseBuilderTest() throws SQLException {
        EmbeddedDatabaseBuilder builder = Helper.getEmbeddedDatabaseBuilder("NAME");
        assertNotNull(builder);
        assertEquals("jdbc:h2:mem:NAME", builder.build().getConnection().getMetaData().getURL());
    }
}
