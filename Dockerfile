FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cptcoffeeusers-0.0.1-SNAPSHOT.jar

EXPOSE 3360

ENTRYPOINT ["java","-jar","/app/cptcoffeeusers-0.0.1-SNAPSHOT.jar"]