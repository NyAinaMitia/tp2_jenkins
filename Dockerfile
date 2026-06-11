FROM eclipse-temurin:8-jre

WORKDIR /app

COPY target/triangle-app-1.0.0.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]