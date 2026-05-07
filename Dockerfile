FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/userlogin.jar userlogin.jar
ENTRYPOINT ["java","-jar","/userlogin.jar"]