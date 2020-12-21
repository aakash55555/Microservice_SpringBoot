FROM openjdk:8
ADD target/docker-egen-assignment.jar docker-egen-assignment.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","docker-egen-assignment.jar"]
