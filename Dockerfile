FROM openjdk:8-jdk-alpine

RUN ./mvnw package

COPY . .

EXPOSE 8080

# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["sh","target/bin/webapp"]
