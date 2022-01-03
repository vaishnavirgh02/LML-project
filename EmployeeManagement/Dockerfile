FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} EmployeeManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/EmployeeManagement-0.0.1-SNAPSHOT.jar"]