FROM openjdk:17
COPY build/libs/webAPIMovieDB-0.0.1-SNAPSHOT.jar webAPIMovieDB-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java", "-jar", "/webAPIMovieDB-0.0.1-SNAPSHOT.jar"]