FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV app_name target/mac_address_lookup-1.0-SNAPSHOT-jar-with-dependencies.jar
RUN apk update && apk upgrade
COPY ${app_name} app.jar

ENTRYPOINT java -jar app.jar -p {api_key} -m 44:38:39:ff:ef:57