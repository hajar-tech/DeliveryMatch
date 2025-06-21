FROM openjdk:17-jdk-alpine
 #copy the jar file
COPY target/Backend-0.0.1-SNAPSHOT.jar delivery-app.jar
 #run the app
ENTRYPOINT ["java","-jar","/delivery-app.jar"]