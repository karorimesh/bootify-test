FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY build/libs/bootify-test-1.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080
