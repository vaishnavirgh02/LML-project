FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} target/EmployeeManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","target/EmployeeManagement-0.0.1-SNAPSHOT.jar"]