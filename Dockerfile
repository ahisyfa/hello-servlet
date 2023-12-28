FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/Hello-Servlet.jar

# cd /usr/local/runme
WORKDIR /usr/local/runme

# copy target/find-links.jar /usr/local/runme/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["java","-jar","app.jar"]