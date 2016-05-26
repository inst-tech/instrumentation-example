# Version: 0.0.1
#FROM java:openjdk-8-jre
#FROM anapsix/alpine-java:jre8
FROM perspicaio/java

MAINTAINER Jonathan Creasy "jonathan.creasy@gmail.com"

ENV JAVA_HOME /usr/lib/jvm/java
ENV WORKDIR /opt/instrumentation
ENV JARNAME instrumentation-all-1.0-SNAPSHOT.jar

RUN mkdir $WORKDIR
WORKDIR $WORKDIR

ADD build/libs/instrumentation-all-1.0-SNAPSHOT.jar $WORKDIR/instrumentation-all-1.0-SNAPSHOT.jar

EXPOSE 8080
EXPOSE 8081

CMD ["java", "-jar", "instrumentation-all-1.0-SNAPSHOT.jar"]
