FROM openjdk:17-jdk-slim as build

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY src ./src

RUN ./gradlew build -x test

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /build/libs/demo.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]