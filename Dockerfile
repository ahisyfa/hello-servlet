FROM openjdk:8-jdk-alpine

COPY . .

RUN ./mvnw package

EXPOSE 8080

# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["sh","target/bin/webapp"]
