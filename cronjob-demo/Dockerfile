FROM openjdk:8-jre-alpine
COPY target/cronjob-demo-1.0-SNAPSHOT.jar /app.jar
WORKDIR /
ENTRYPOINT ["java", "-cp", "app.jar", "com.sren.demo.Main"]
