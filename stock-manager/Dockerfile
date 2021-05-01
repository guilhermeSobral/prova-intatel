FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD ./target/stock-manager-0.0.1-SNAPSHOT.jar stock-manager.jar
ENTRYPOINT ["java","-jar","/stock-manager.jar"]
