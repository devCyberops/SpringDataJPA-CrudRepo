FROM maven as build
COPY . .
RUN mvn clean install

FROM openjdk:11.0
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
