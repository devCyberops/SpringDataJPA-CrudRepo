FROM openjdk:8-jre-alpine
ADD target/achat-1.0.jar achat-1.0.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]
