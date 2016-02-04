package net.ghostlab.instrumentation.application;
/**
 * Copyright 2015 The instrumentation Authors
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.codahale.metrics.jetty9.InstrumentedConnectionFactory;
import com.codahale.metrics.jetty9.InstrumentedHandler;
import com.codahale.metrics.jetty9.InstrumentedQueuedThreadPool;
import com.codahale.metrics.servlets.AdminServlet;
import com.codahale.metrics.servlets.HealthCheckServlet;
import com.codahale.metrics.servlets.MetricsServlet;
import net.ghostlab.datasources.Connection;
import net.ghostlab.datasources.factory.DatasourceConnectionFactory;
import net.ghostlab.datasources.factory.MySqlConnectionFactory;
import net.ghostlab.datasources.factory.PostgreSqlConnectionFactory;
import net.ghostlab.healthchecks.DatabaseHealthCheck;
import net.ghostlab.instrumentation.ApplicationMain;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
  static final DatasourceConnectionFactory dbFactory = new MySqlConnectionFactory();
  static final DatasourceConnectionFactory pgDBFactory = new PostgreSqlConnectionFactory();
  static final Connection dbConnection = dbFactory.getConnection();
  static final Connection pgDBConnection = pgDBFactory.getConnection();

  private static final Logger LOG = LoggerFactory.getLogger(Application.class);

  private Integer applicationPort;
  private Integer adminPort;
  private String adminPath;

  public String getApplicationPath() {
    return applicationPath;
  }

  public void setApplicationPath(String applicationPath) {
    this.applicationPath = applicationPath;
  }

  public Integer getApplicationPort() {
    return applicationPort;
  }

  public void setApplicationPort(Integer mainPort) {
    this.applicationPort = mainPort;
  }

  public Integer getAdminPort() {
    return adminPort;
  }

  public void setAdminPort(Integer adminPort) {
    this.adminPort = adminPort;
  }

  public String getAdminPath() {
    return adminPath;
  }

  public void setAdminPath(String adminPath) {
    this.adminPath = adminPath;
  }

  private String applicationPath;

  public Application() {
    setApplicationPort(8080);
    setApplicationPath("/application/*");
    setAdminPort(8081);
    setAdminPath("/admin/*");
    LOG.debug("Initializing Healthchecks");
    ApplicationMain.healthChecks.register("mysql", new DatabaseHealthCheck(dbConnection));
    ApplicationMain.healthChecks.register("PostgreSQL", new DatabaseHealthCheck(pgDBConnection));
    dbConnection.connect();
  }

  public void start() {
    LOG.info("Creating HTTP servers");
    Server mainServer = configureServer(getApplicationPort());
    Server adminServer = configureServer(getAdminPort());

    LOG.info("Creating HTTP handlers");
    mainServer.setHandler(getApplicationHandler());
    adminServer.setHandler(getAdminHandler());

    LOG.info("Starting HTTP servers");

    try {
      adminServer.start();
      mainServer.start();
    } catch (Exception e) {
      e.printStackTrace();
    }

    LOG.info("Joining...");

    try {
      mainServer.join();
      adminServer.join();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  private Server configureServer(Integer mainPort) {
    LOG.info("Creating Server for port " + mainPort);
    final ThreadPool threadPool = new InstrumentedQueuedThreadPool(ApplicationMain.metrics);
    final Server mainServer = new Server(threadPool);
    final ServerConnector mainConnector = new ServerConnector(mainServer,
            new InstrumentedConnectionFactory(new HttpConnectionFactory(),
                    ApplicationMain.metrics.timer("http.connection")));
    mainConnector.setPort(mainPort);
    mainServer.addConnector(mainConnector);
    return mainServer;
  }

  private ServletContextHandler createContextHandler() {
    final ServletContextHandler mainHandler = new ServletContextHandler();
    return mainHandler;
  }

  private void addApplicationServlets(ServletHandler handler) {
    LOG.info("ApplicationServlets added at: " + getApplicationPath());
    handler.addServletWithMapping(ApplicationServlet.class.getName(), getApplicationPath());
  }

  private void addAdminServlets(ServletContextHandler adminHandler) {
    LOG.info("AdminServlets added at: " + getAdminPath());
    final ServletHolder adminHolder = new ServletHolder(new AdminServlet());
    adminHandler.setAttribute(MetricsServlet.METRICS_REGISTRY, ApplicationMain.metrics);
    adminHandler.setAttribute(HealthCheckServlet.HEALTH_CHECK_REGISTRY, ApplicationMain.healthChecks);
    adminHandler.addServlet(adminHolder, getAdminPath());
  }

  private InstrumentedHandler getInstrumentedHandler(Handler handler) {
    final InstrumentedHandler instrumentedHandler =
            new InstrumentedHandler(ApplicationMain.metrics);
    instrumentedHandler.setHandler(handler);
    return instrumentedHandler;
  }

  private InstrumentedHandler getAdminHandler() {
    ServletContextHandler handler = createContextHandler();
    addAdminServlets(handler);
    InstrumentedHandler instrumentedHandler = getInstrumentedHandler(handler);
    return instrumentedHandler;
  }

  private InstrumentedHandler getApplicationHandler() {
    ServletHandler handler = new ServletHandler();
    addApplicationServlets(handler);
    InstrumentedHandler instrumentedHandler = getInstrumentedHandler(handler);
    return instrumentedHandler;
  }

  private HandlerCollection getHandlerSet() {
    HandlerCollection handlerCollection = new HandlerCollection();
    InstrumentedHandler applicationHandler = getApplicationHandler();
    InstrumentedHandler adminHandler = getAdminHandler();
    handlerCollection.setHandlers(new Handler[] {applicationHandler, adminHandler});
    return handlerCollection;
  }
}