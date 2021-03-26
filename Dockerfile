FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
ADD target/spring-boot-mysql-quartz-scheduler.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]