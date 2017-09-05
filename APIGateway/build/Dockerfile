FROM java

ADD APIGateway_jar build/* /jar
CMD ["/usr/bin/java", "-jar", "/jar/APIGateway.jar", "-l", "debug"]
