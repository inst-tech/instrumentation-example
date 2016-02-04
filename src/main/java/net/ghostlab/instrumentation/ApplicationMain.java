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

import com.codahale.metrics.*;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.codahale.metrics.jvm.BufferPoolMetricSet;
import com.codahale.metrics.jvm.CachedThreadStatesGaugeSet;
import com.codahale.metrics.jvm.ClassLoadingGaugeSet;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.health.jvm.ThreadDeadlockHealthCheck;
import net.ghostlab.instrumentation.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.util.Map;
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
    registerAll("jvm.gc", new GarbageCollectorMetricSet(), metrics);
    registerAll("jvm.buffers", new BufferPoolMetricSet(ManagementFactory.getPlatformMBeanServer()), metrics);
    registerAll("jvm.memory", new MemoryUsageGaugeSet(), metrics);
    registerAll("jvm.threads", new ThreadStatesGaugeSet(), metrics);
//    registerAll("jvm.threads.cached", new CachedThreadStatesGaugeSet(30, TimeUnit.SECONDS), metrics);
//    registerAll("jvm.class.loading", new ClassLoadingGaugeSet(), metrics);

    healthChecks.register("DeadlockDetection", new ThreadDeadlockHealthCheck());
    Slf4jReporter logbackReporter = Slf4jReporter.forRegistry( metrics ).outputTo( LOG )
            .convertRatesTo( TimeUnit.SECONDS )
            .convertDurationsTo( TimeUnit.MILLISECONDS ).build();
    logbackReporter.start( 1, TimeUnit.MINUTES );
    ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
    consoleReporter.start(1, TimeUnit.MINUTES);
  }

  static void registerAll(String prefix, MetricSet metricSet, MetricRegistry registry) {
    for (Map.Entry<String, Metric> entry : metricSet.getMetrics().entrySet()) {
      if (entry.getValue() instanceof MetricSet) {
        registerAll(prefix + "." + entry.getKey(), (MetricSet) entry.getValue(), registry);
      } else {
        registry.register(prefix + "." + entry.getKey(), entry.getValue());
      }
    }
  }
}
