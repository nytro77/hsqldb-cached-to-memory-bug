package com.example.hsqldbbug;

import java.nio.file.Files;

import org.hsqldb.jdbc.JDBCDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class HsqldbBugApplicationTests {

	@Test
	void contextLoads() throws Exception {

		JDBCDataSource jdbcDataSource = new JDBCDataSource();
		jdbcDataSource.setUrl("jdbc:hsqldb:file:" + Files.createTempDirectory("test").resolve("db").toString());

		JdbcTemplate jdbcTemplate = new JdbcTemplate(jdbcDataSource);
		jdbcTemplate.update("CREATE CACHED TABLE THETABLE(ID INTEGER)");
		jdbcTemplate.update("SET TABLE THETABLE TYPE MEMORY"); // Fails with hsqldb 2.6.0 and 2.6.1. Works with 2.5.1

	}

}
