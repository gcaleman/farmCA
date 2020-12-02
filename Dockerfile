FROM openjdk:latest as build

WORKDIR /build/

COPY . .

RUN ./gradlew bootJar

FROM openjdk as run

WORKDIR /app/

COPY --from=build /build/build/libs/farmCA-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]