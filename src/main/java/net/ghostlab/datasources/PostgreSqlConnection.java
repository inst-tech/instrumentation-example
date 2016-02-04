package net.ghostlab.datasources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostgreSqlConnection implements Connection {

	private static final Logger LOG = LoggerFactory.getLogger(MySqlConnection.class);
	private boolean connectionState = false;

	@Override
	public void connect() {
		LOG.info("Connecting to PostgreSql...");
		this.connectionState = true;
	}

	@Override
	public boolean isConnected() {
		return this.connectionState;
	}

	@Override
	public String getUrl() {
		return "/tmp/pgsql.sock";
	}

}
