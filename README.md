# instrumentation-example
Example Project for using Dropwizard Metrics, useful for testing projects that interact with administrative functions
```
gradle fatfar
java -jar build/libs/instrumentation-all-1.0-SNAPSHOT.jar -DmainPort=8031 -DadminPort=8023 -DapplicationPath=/ 
```
