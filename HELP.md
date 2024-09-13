# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.3/gradle-plugin/packaging-oci-image.html)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/3.3.3/reference/testing/testcontainers.html#testing.testcontainers)
* [Testcontainers Cassandra Module Reference Guide](https://java.testcontainers.org/modules/databases/cassandra/)
* [Testcontainers Couchbase Module Reference Guide](https://java.testcontainers.org/modules/databases/couchbase/)
* [Testcontainers Elasticsearch Container Reference Guide](https://java.testcontainers.org/modules/elasticsearch/)
* [Testcontainers MongoDB Module Reference Guide](https://java.testcontainers.org/modules/databases/mongodb/)
* [Testcontainers Neo4j Module Reference Guide](https://java.testcontainers.org/modules/databases/neo4j/)
* [Testcontainers Kafka Modules Reference Guide](https://java.testcontainers.org/modules/kafka/)
* [Testcontainers MariaDB Module Reference Guide](https://java.testcontainers.org/modules/databases/mariadb/)
* [Testcontainers MySQL Module Reference Guide](https://java.testcontainers.org/modules/databases/mysql/)
* [Testcontainers Oracle-Free Module Reference Guide](https://java.testcontainers.org/modules/databases/oraclefree/)
* [Testcontainers Postgres Module Reference Guide](https://java.testcontainers.org/modules/databases/postgres/)
* [Testcontainers MS SQL Server Module Reference Guide](https://java.testcontainers.org/modules/databases/mssqlserver/)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#actuator)
* [Spring Data for Apache Cassandra](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.nosql.cassandra)
* [Spring Data Couchbase](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.nosql.couchbase)
* [Spring Data Elasticsearch (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.nosql.elasticsearch)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.sql.jdbc)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.nosql.mongodb)
* [Spring Data Neo4j](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.nosql.neo4j)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.nosql.redis)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#messaging.kafka)
* [Apache Kafka Streams Support](https://docs.spring.io/spring-kafka/docs/current/reference/html/#streams-kafka-streams)
* [Apache Kafka Streams Binding Capabilities of Spring Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/index.html#_kafka_streams_binding_capabilities_of_spring_cloud_stream)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.liquibase)
* [Prometheus](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#actuator.metrics.export.prometheus)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web)
* [WebSocket](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#messaging.websockets)
* [Testcontainers](https://java.testcontainers.org/)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#io.quartz)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Spring Data for Apache Cassandra](https://spring.io/guides/gs/accessing-data-cassandra/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Accessing Data with Neo4j](https://spring.io/guides/gs/accessing-data-neo4j/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Samples for using Apache Kafka Streams with Spring Cloud stream](https://github.com/spring-cloud/spring-cloud-stream-samples/tree/master/kafka-streams-samples)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Testcontainers support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/3.3.3/reference/features/dev-services.html#features.dev-services.testcontainers).

Testcontainers has been configured to use the following Docker images:

* [`cassandra:latest`](https://hub.docker.com/_/cassandra)
* [`docker.elastic.co/elasticsearch/elasticsearch:7.17.10`](https://www.docker.elastic.co/r/elasticsearch)
* [`confluentinc/cp-kafka:latest`](https://hub.docker.com/r/confluentinc/cp-kafka)
* [`mariadb:latest`](https://hub.docker.com/_/mariadb)
* [`mongo:latest`](https://hub.docker.com/_/mongo)
* [`mysql:latest`](https://hub.docker.com/_/mysql)
* [`neo4j:latest`](https://hub.docker.com/_/neo4j)
* [`gvenzl/oracle-free:latest`](https://hub.docker.com/r/gvenzl/oracle-free)
* [`postgres:latest`](https://hub.docker.com/_/postgres)
* [`redis:latest`](https://hub.docker.com/_/redis)
* [`mcr.microsoft.com/mssql/server:latest`](https://mcr.microsoft.com/en-us/product/mssql/server/about/)

Please review the tags of the used images and set them to the same as you're running in production.

