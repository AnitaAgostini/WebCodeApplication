package com.Application;

public class DataSource {

	private static HikariConfig config = new HkariConfig();
	private static HikariDataSource ds;
	static {
		config.setDriverClassName("oracle.jdbc.OracleDriver");
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		config.setUsername("system");
		config.setPassword("admin");
		ds = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
}
