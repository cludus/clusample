# Cludus Code Examples

Cludus code examples for integrating different technologies

# Web Configuration

Setup the following environment variables:

```
ALLOWED_ORIGIN_PATTERNS=http://localhost:[*]
```

# JPA Configuration

Setup the following environment variables:

```
ACTIVE_PROFILES=jpa
LIQUIBASE_ENABLED=true
LIQUIBASE_CLEAR_CHECKSUM=false
JPA_ENABLED=true
JDBC_USERNAME=<username>
JDBC_PASSWORD=<password>
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
JDBC_DRIVER=<diver>
JDBC_URL=<jdbc url>
HIBERNATE_DIALECT=<dialect>
```

## Postgres

```
ACTIVE_PROFILES=jpa
LIQUIBASE_ENABLED=true
LIQUIBASE_CLEAR_CHECKSUM=false
JPA_ENABLED=true
JDBC_USERNAME=clugestuser
JDBC_PASSWORD=kjl3J9h9hH32Gddhk
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
JDBC_DRIVER=org.postgresql.Driver
JDBC_URL=jdbc:postgresql://postgres.clugest.home:5432/clugest
HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect
```

## MariaDB

```
ACTIVE_PROFILES=jpa
LIQUIBASE_ENABLED=true
LIQUIBASE_CLEAR_CHECKSUM=false
JPA_ENABLED=true
JDBC_USERNAME=clugestuser
JDBC_PASSWORD=kjl3J9h9hH32Gddhk
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
JDBC_DRIVER=org.mariadb.jdbc.Driver
JDBC_URL=jdbc:mariadb://mariadb.clugest.home:3306/clugest
HIBERNATE_DIALECT=org.hibernate.dialect.MariaDBDialect
```

## Oracle

```
ACTIVE_PROFILES=jpa
LIQUIBASE_ENABLED=true
LIQUIBASE_CLEAR_CHECKSUM=false
JPA_ENABLED=true
JDBC_USERNAME=system
JDBC_PASSWORD=kjl3J9h9hH32Gddhk
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
JDBC_DRIVER=oracle.jdbc.OracleDriver
JDBC_URL=jdbc:oracle:thin:@//oracle.clugest.home:11521
HIBERNATE_DIALECT=org.hibernate.dialect.OracleDialect
```

## MSSQL

```
ACTIVE_PROFILES=jpa
LIQUIBASE_ENABLED=true
LIQUIBASE_CLEAR_CHECKSUM=false
JPA_ENABLED=true
JDBC_USERNAME=sa
JDBC_PASSWORD=kjl3J9h9hH32Gddhk
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
JDBC_DRIVER=com.microsoft.sqlserver.jdbc.SQLServerDriver
JDBC_URL=jdbc:sqlserver://sqlserver.clugest.home;databaseName=clugest
HIBERNATE_DIALECT=org.hibernate.dialect.SQLServer2012Dialect
```

## Derby

```
ACTIVE_PROFILES=jpa
LIQUIBASE_ENABLED=true
LIQUIBASE_CLEAR_CHECKSUM=false
JPA_ENABLED=true
JDBC_USERNAME=<username>
JDBC_PASSWORD=<password>
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
JDBC_DRIVER=
JDBC_URL=
HIBERNATE_DIALECT=
```

## H2

```
ACTIVE_PROFILES=jpa
LIQUIBASE_ENABLED=true
LIQUIBASE_CLEAR_CHECKSUM=false
JPA_ENABLED=true
JDBC_USERNAME=<username>
JDBC_PASSWORD=<password>
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
JDBC_DRIVER=
JDBC_URL=
HIBERNATE_DIALECT=
```

# MongoDB Configuration

Setup the following environment variables:

```
ACTIVE_PROFILES=mongodb
MONGODB_URI=mongodb://mongo.clugest.home:27017/clugest
MONGODB_USERNAME=clugestuser
MONGODB_PASSWORD=kjl3J9h9hH32Gddhk
```

# Elasticsearch Configuration

Setup the following environment variables:

```
ACTIVE_PROFILES=elasticsearch
ELASTICSEARCH_URIS=http://localhost:9200
ELASTICSEARCH_USERNAME=elastic
ELASTICSEARCH_PASSWORD=password
```

# Neo4j Configuration

Setup the following environment variables:

```
ACTIVE_PROFILES=neo4j
NEO4J_URI=bolt://neo4j.clugest.home:7687
NEO4J_USERNAME=neo4j
NEO4J_PASSWORD=kjl3J9h9hH32Gddhk
```

# Cassandra Configuration

Setup the following environment variables:

```
ACTIVE_PROFILES=cassandra
CASSANDRA_CONTACT_POINTS=localhost:9042
CASSANDRA_USERNAME=cassandra
CASSANDRA_PASSWORD=cassandra
CASSANDRA_KEYSPACE=clugest
CASSANDRA_LOCAL_DC=dc1
```

# Kafka Configuration

Setup the following environment variables:

```
ACTIVE_PROFILES=kafka
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
KAFKA_ADMIN_CLIENT_ID=1
KAFKA_CONSUMER_CLIENT_ID=1
KAFKA_CONSUMER_GROUP_ID=1
KAFKA_PRODUCER_CLIENT_ID=1
```
