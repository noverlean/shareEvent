FROM openjdk:17
EXPOSE 8080
COPY target/shareEvent-0.0.1-SNAPSHOT.jar app.jar
ENV POSTGRES_SCHEMA "public"
ENTRYPOINT ["java","-XX:MaxRAM=100M", "-jar", "/app.jar"]