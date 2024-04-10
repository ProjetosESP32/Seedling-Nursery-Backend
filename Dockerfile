FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /builder

COPY mvnw .
RUN chmod +x mvnw

COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN --mount=type=cache,target=/root/.m2 ./mvnw package -DskipTests

FROM eclipse-temurin:17-jre-alpine AS prod
RUN addgroup -S spring && adduser -S spring -G spring --home /home/spring
USER spring

RUN mkdir -p /home/spring/app
WORKDIR /home/spring/app

COPY --chown=spring:spring --from=build /builder/target/app-exec.jar .

CMD ["java", "-Dspring.profiles.active=prod", "-jar", "app-exec.jar"]
