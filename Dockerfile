FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/allo-backend-test-0.0.1-SNAPSHOT.jar allo-backend-test.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "allo-backend-test.jar"]