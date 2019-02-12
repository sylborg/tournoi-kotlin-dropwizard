# tournoi kotlin dropwizard

How to start the tournoiApplication
---

1. Run `mvn clean install` to build your tournoiApplication
1. Start tournoiApplication with `java -jar target/classement-1.0-SNAPSHOT.jar server config.yml`
1. To check that your tournoiApplication is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
