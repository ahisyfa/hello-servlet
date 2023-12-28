FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-8-jdk -y
COPY . .
RUN ./mvnw package
RUN sh target/bin/webapp

EXPOSE 8080