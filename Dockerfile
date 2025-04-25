FROM gradle:8.13-jdk AS build
LABEL authors="vromanyu"
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false"

WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

FROM openjdk:21-oracle
WORKDIR /thymeleaf-blog
COPY --from=build /app/build/libs/thymeleaf-project-0.0.1-SNAPSHOT.jar ./application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]