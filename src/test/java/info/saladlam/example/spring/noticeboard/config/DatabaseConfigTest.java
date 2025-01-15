package info.saladlam.example.spring.noticeboard.config;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConfigTest {

    @Test
    void dataSourceURL() throws SQLException {
        DatabaseConfig config = new DatabaseConfig();
        Connection connection = config.dataSource().getConnection();
        assertEquals("jdbc:h2:mem:noticeboard", connection.getMetaData().getURL());
    }
}