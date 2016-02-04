package net.ghostlab.instrumentation;
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

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import net.ghostlab.instrumentation.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationMain {
  public static final HealthCheckRegistry healthChecks = new HealthCheckRegistry();
  public static final MetricRegistry metrics = new MetricRegistry();
  private static final Logger LOG = LoggerFactory.getLogger(ApplicationMain.class);

  public static void main(String args[]) {
    Integer mainPort = Integer.parseInt(System.getProperty("mainPort", "8080"));
    Integer adminPort = Integer.parseInt(System.getProperty("adminPort", "8081"));

    LOG.info("Application Configured to listen on port " + mainPort);
    LOG.info("Admin Configured to listen on port " + adminPort);

    LOG.debug("Initializing Metrics");
    startReport();

    LOG.info("Creating Jetty Server");
    Application webapp = new Application();

    LOG.info("Configuring Jetty Server");
    webapp.setAdminPort(adminPort);
    webapp.setApplicationPort(mainPort);
    webapp.setApplicationPath(System.getProperty("applicationPath", "/application"));

    LOG.info("Starting Jetty Server");
    webapp.start();

    LOG.info("We're done!");
 }

  static void startReport() {
    ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
    reporter.start(30, TimeUnit.SECONDS);
  }
}
