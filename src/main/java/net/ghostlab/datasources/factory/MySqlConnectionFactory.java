package net.ghostlab.datasources.factory;

import net.ghostlab.datasources.Connection;
import net.ghostlab.datasources.MySqlConnection;

public class MySqlConnectionFactory implements DatasourceConnectionFactory {

	@Override
	public Connection getConnection() {
		return new MySqlConnection();
	}

}
