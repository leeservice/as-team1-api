# Maven base image
FROM maven:latest

#Working directory, copies code to Docker image
WORKDIR /code
COPY . /code

# db connection args and env variables
ARG DB_HOST
ENV DB_HOST ${DB_HOST}

ARG DB_NAME
ENV DB_NAME ${DB_NAME}

ARG DB_USERNAME
ENV DB_USERNAME ${DB_USERNAME}

ARG DB_PASSWORD
ENV DB_PASSWORD ${DB_PASSWORD}

#Runs clean install and tests
RUN mvn clean install -DskipTests=true

#Listens to port 8080
EXPOSE 8080

#Execute image with params
CMD ["java","-jar", "/code/target/kainos_academy_as-team1-api-1.0-SNAPSHOT.jar", "server", "/code/config.yml"]