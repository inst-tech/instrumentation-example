package net.ghostlab.datasources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlConnection implements Connection {
	private static final Logger LOG = LoggerFactory.getLogger(MySqlConnection.class);
	private boolean connectionState = false;

	@Override
	public void connect() {
		LOG.info("Connecting to MySQL...");
		this.connectionState = true;
	}

	@Override
	public boolean isConnected() {
		return this.connectionState;
	}

	@Override
	public String getUrl() {
		return "/tmp/mysql.sock";
	}

}
