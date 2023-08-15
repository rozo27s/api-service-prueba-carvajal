# Ebusiness for ebusiness-api-1.0-local-SNAPSHOT
# ./gradlew clean build
# Build image with:  docker build -t ebusiness-api .

### Cambiar la imagen linux para despligue en produccion
FROM amazoncorretto:11
LABEL key="Carvajal"

ADD build/libs /opt/spring-boot
#ADD src/main/resources/config  /opt/config

### Set Environment
ENV SERVER_HOME /opt/spring-boot

WORKDIR /opt/spring-boot

### Open Ports
EXPOSE 8080

### Start instance
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "-Dfile.encoding=UTF-8", "/opt/spring-boot/service-api-rest-0.0.1.jar"]
