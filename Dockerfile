FROM java:8
EXPOSE 8080
VOLUME /tmp
COPY build/libs/ELN.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]