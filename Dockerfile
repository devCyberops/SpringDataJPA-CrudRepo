FROM openjdk:8-jre-alpine
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
