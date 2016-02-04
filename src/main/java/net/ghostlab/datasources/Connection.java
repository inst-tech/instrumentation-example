package net.ghostlab.datasources;

public interface Connection {

	public void connect();
	public boolean isConnected();
  public String getUrl();
}
