
FROM openjdk:11

WORKDIR /app

COPY . .

RUN mv .env.example /app/.env

# Link Java install directory to our previously defined "docker-java-home" folder
RUN ln -s "${JAVA_HOME}" /docker-java-home

EXPOSE 8080
