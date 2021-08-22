FROM openjdk:8-jdk-alpine
LABEL maintainer="shdlehdwls@gmail.com"
VOLUME /tmp
ARG JAR_FILE=./build/libs/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
#ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://192.168.0.36/admin", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://192.168.219.160/admin", "-jar", "/app.jar"]