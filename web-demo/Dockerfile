FROM openjdk:8-jre-alpine
COPY target/web-demo-0.0.1-SNAPSHOT.jar /app.jar
WORKDIR /
ENTRYPOINT ["java", "-jar", "app.jar"]
