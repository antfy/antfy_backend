FROM gradle:7.2.0-jdk11 AS build
COPY --chown=gradle:gradle . /home/antfy
WORKDIR /home/antfy
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/antfy/build/libs/*.jar /app/antfy_app.jar

ENTRYPOINT ["java","-jar", "/app/antfy_app.jar"]