package net.ghostlab.datasources.factory;

import net.ghostlab.datasources.Connection;
import net.ghostlab.datasources.PostgreSqlConnection;

public class PostgreSqlConnectionFactory implements DatasourceConnectionFactory {

	@Override
	public Connection getConnection() {
		return new PostgreSqlConnection();
	}

}
