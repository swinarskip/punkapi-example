# Punkapi Example

Simple example of using [PUNK API](https://punkapi.com) and [HSQLDB](http://hsqldb.org).

## Run the application

```
./gradlew bootRun
```

+ Open [http://localhost](http://localhost) in your browser

## Build JAR

```
./gradlew build
```

```
java -jar ./build/libs/punkapi-example-1.0.2.jar
```

## Get beers

```
curl http://localhost
```

## Find beers by food pairing

```
curl http://localhost/foodpairings/search/lemon
```

## Create beer

```
curl -X POST -i --user admin:admin -d name=Tyskie http://localhost/beers
```

## Check in HSQLDB

1. Connect using [http://localhost/console](http://localhost/console)
2. Use JDBC URL `jdbc:h2:mem:app_db`
3. Run the query `SELECT * FROM BEER`