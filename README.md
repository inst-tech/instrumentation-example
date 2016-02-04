# instrumentation-example
Example Project for using Dropwizard Metrics, useful for testing projects that interact with administrative functions

You can run this and it has a simple hello world on http://localhost:8031/.
There will be health checks and metrics on http://localhost:8023/admin

This is useful for testing projects that want to interact with Dropwizard Metrics

## Run It:
```
gradle fatfar
java -DmainPort=8031 -DadminPort=8023 -DapplicationPath=/ -jar build/libs/instrumentation-all-1.0-SNAPSHOT.jar
```
## Healthchecks
http://localhost:8023/admin/healthcheck?pretty=true
```
{
  "PostgreSQL" : {
    "healthy" : false,
    "message" : "Cannot connect to /tmp/pgsql.sock"
  },
  "mysql" : {
    "healthy" : true
  }
}
```
## Metrics
http://localhost:8023/admin/metrics?pretty=true
```
{
  "version" : "3.0.0",
  "gauges" : {
    "org.eclipse.jetty.servlet.ServletContextHandler.percent-4xx-15m" : {
      "value" : 0.0
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.percent-4xx-1m" : {
      "value" : 0.0
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.percent-4xx-5m" : {
      "value" : 0.0
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.percent-5xx-15m" : {
      "value" : 1.0
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.percent-5xx-1m" : {
      "value" : 1.0
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.percent-5xx-5m" : {
      "value" : 1.0
    },
    "org.eclipse.jetty.servlet.ServletHandler.percent-4xx-15m" : {
      "value" : "NaN"
    },
    "org.eclipse.jetty.servlet.ServletHandler.percent-4xx-1m" : {
      "value" : "NaN"
    },
    "org.eclipse.jetty.servlet.ServletHandler.percent-4xx-5m" : {
      "value" : "NaN"
    },
    "org.eclipse.jetty.servlet.ServletHandler.percent-5xx-15m" : {
      "value" : "NaN"
    },
    "org.eclipse.jetty.servlet.ServletHandler.percent-5xx-1m" : {
      "value" : "NaN"
    },
    "org.eclipse.jetty.servlet.ServletHandler.percent-5xx-5m" : {
      "value" : "NaN"
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp1393931310.jobs" : {
      "value" : 0
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp1393931310.size" : {
      "value" : 8
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp1393931310.utilization" : {
      "value" : 0.75
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp1393931310.utilization-max" : {
      "value" : 0.03
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp2094777811.jobs" : {
      "value" : 0
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp2094777811.size" : {
      "value" : 8
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp2094777811.utilization" : {
      "value" : 0.625
    },
    "org.eclipse.jetty.util.thread.QueuedThreadPool.qtp2094777811.utilization-max" : {
      "value" : 0.025
    }
  },
  "counters" : {
    "org.eclipse.jetty.servlet.ServletContextHandler.active-dispatches" : {
      "count" : 1
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.active-requests" : {
      "count" : 1
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.active-suspended" : {
      "count" : 0
    },
    "org.eclipse.jetty.servlet.ServletHandler.active-dispatches" : {
      "count" : 0
    },
    "org.eclipse.jetty.servlet.ServletHandler.active-requests" : {
      "count" : 0
    },
    "org.eclipse.jetty.servlet.ServletHandler.active-suspended" : {
      "count" : 0
    }
  },
  "histograms" : { },
  "meters" : {
    "org.eclipse.jetty.servlet.ServletContextHandler.1xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.2xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.3xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.4xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.5xx-responses" : {
      "count" : 2,
      "m15_rate" : 0.393388581528647,
      "m1_rate" : 0.311520313228562,
      "m5_rate" : 0.3804917698002856,
      "mean_rate" : 0.08394401782601081,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.async-dispatches" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.async-timeouts" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.1xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.2xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.3xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.4xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.5xx-responses" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.async-dispatches" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.async-timeouts" : {
      "count" : 0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "units" : "events/second"
    }
  },
  "timers" : {
    "http.connection" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.connect-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.delete-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.dispatches" : {
      "count" : 2,
      "max" : 0.033,
      "mean" : 0.01676001799838015,
      "min" : 0.001,
      "p50" : 0.001,
      "p75" : 0.033,
      "p95" : 0.033,
      "p98" : 0.033,
      "p99" : 0.033,
      "p999" : 0.033,
      "stddev" : 0.01599820016873456,
      "m15_rate" : 0.393388581528647,
      "m1_rate" : 0.311520313228562,
      "m5_rate" : 0.3804917698002856,
      "mean_rate" : 0.08393494054495682,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.get-requests" : {
      "count" : 2,
      "max" : 0.034,
      "mean" : 0.01725251856082953,
      "min" : 0.001,
      "p50" : 0.001,
      "p75" : 0.034,
      "p95" : 0.034,
      "p98" : 0.034,
      "p99" : 0.034,
      "p999" : 0.034,
      "stddev" : 0.016498143924007516,
      "m15_rate" : 0.393388581528647,
      "m1_rate" : 0.311520313228562,
      "m5_rate" : 0.3804917698002856,
      "mean_rate" : 0.08393499225231109,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.head-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.move-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.options-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.other-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.post-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.put-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.requests" : {
      "count" : 2,
      "max" : 0.034,
      "mean" : 0.01725251856082953,
      "min" : 0.001,
      "p50" : 0.001,
      "p75" : 0.034,
      "p95" : 0.034,
      "p98" : 0.034,
      "p99" : 0.034,
      "p999" : 0.034,
      "stddev" : 0.016498143924007516,
      "m15_rate" : 0.393388581528647,
      "m1_rate" : 0.311520313228562,
      "m5_rate" : 0.3804917698002856,
      "mean_rate" : 0.08393209816863162,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletContextHandler.trace-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.connect-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.delete-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.dispatches" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.get-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.head-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.move-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.options-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.other-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.post-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.put-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    },
    "org.eclipse.jetty.servlet.ServletHandler.trace-requests" : {
      "count" : 0,
      "max" : 0.0,
      "mean" : 0.0,
      "min" : 0.0,
      "p50" : 0.0,
      "p75" : 0.0,
      "p95" : 0.0,
      "p98" : 0.0,
      "p99" : 0.0,
      "p999" : 0.0,
      "stddev" : 0.0,
      "m15_rate" : 0.0,
      "m1_rate" : 0.0,
      "m5_rate" : 0.0,
      "mean_rate" : 0.0,
      "duration_units" : "seconds",
      "rate_units" : "calls/second"
    }
  }
}
```
