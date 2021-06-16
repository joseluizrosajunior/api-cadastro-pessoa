FROM java:8
EXPOSE 8080
ADD target/cadastropessoa-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]