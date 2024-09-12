# Cludus Data Ingest

Cludus tools for extraction transformation and load of third-party data

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
JDBC_USERNAME=postgres
JDBC_PASSWORD=postgres
HIKARI_MINIMUM_IDLE=1
HIKARI_MAXIMUM_POOL_SIZE=10
HIKARI_CONNECTION_TIMEOUT=30000
```

## Postgres

```
JDBC_DRIVER=org.postgresql.Driver
JDBC_URL=jdbc:postgresql://localhost:5432/clugest
HIBERNATE_DIALECT=org.hibernate.dialect.PostgreSQLDialect
```

## MariaDB

```
JDBC_DRIVER=
JDBC_URL=
HIBERNATE_DIALECT=
```

## Oracle

```
JDBC_DRIVER=
JDBC_URL=
HIBERNATE_DIALECT=
```

## MSSQL

```
JDBC_DRIVER=
JDBC_URL=
HIBERNATE_DIALECT=
```

## Derby

```
JDBC_DRIVER=
JDBC_URL=
HIBERNATE_DIALECT=
```

## H2

```
JDBC_DRIVER=
JDBC_URL=
HIBERNATE_DIALECT=
```

# MongoDB Configuration

Setup the following environment variables:

```
ACTIVE_PROFILES=mongodb
MONGODB_URI=mongodb://localhost:27017/clugest
MONGODB_USERNAME=admin
MONGODB_PASSWORD=password
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
NEO4J_URI=bolt://localhost:7687
NEO4J_USERNAME=neo4j
NEO4J_PASSWORD=password
```

# Cassandra Configuration

Setup the following environment variables:

```
CASSANDRA_CONTACT_POINTS=localhost:9042
CASSANDRA_USERNAME=cassandra
CASSANDRA_PASSWORD=cassandra
CASSANDRA_KEYSPACE=clugest
CASSANDRA_LOCAL_DC=dc1
```

# Kafka Configuration

Setup the following environment variables:

```
KAFKA_BOOTSTRAP_SERVERS=localhost:9092
KAFKA_ADMIN_CLIENT_ID=1
KAFKA_CONSUMER_CLIENT_ID=1
KAFKA_CONSUMER_GROUP_ID=1
KAFKA_PRODUCER_CLIENT_ID=1
```