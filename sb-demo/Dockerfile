FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Skip the git-commit-id plugin as the .git directory is not available in the container
RUN mvn clean package -DskipTests -Dgit-commit-id.skip=true

FROM eclipse-temurin:21-jdk
COPY --from=build /app/target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]