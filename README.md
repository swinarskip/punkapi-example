# Punkapi Example

## Run the application

+ Run the application:

```
./gradlew bootRun
```

+ Package the JAR:

```
./gradlew build
```

## Create beer

```
curl -X POST -i --user admin:test http://localhost
```

## Get beers

```
curl http://localhost
```

## Check in HSQLDB

1. Connect using http://localhost:8080/console
2. Use JDBC URL `jdbc:h2:mem:app_db`
3. Run the query `SELECT * FROM EMPLOYEE`