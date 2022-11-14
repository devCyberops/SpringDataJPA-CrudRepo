FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o achat-1.0.jar "http://192.168.100.86:8081/service/rest/repository/browse/maven-releases/" -L
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
EXPOSE 8083
