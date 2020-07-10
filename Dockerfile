FROM openjdk:8
ADD target/docker-calculator.jar docker-calculator.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","docker-calculator.jar"]