FROM openjdk:11
EXPOSE 8089
COPY target/acha-1.0.jar achat.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]
