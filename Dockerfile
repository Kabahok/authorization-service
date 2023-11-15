FROM --platform=linux/arm64/v8 khipu/openjdk17-alpine

EXPOSE 8080

ADD target/authorization-service-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]