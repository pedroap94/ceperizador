FROM openjdk

RUN mkdir /app

ENV APP_NAME = ceperizador-app.war

COPY target/ceperizador-app.war /app

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "/app/ceperizador-app.war"]