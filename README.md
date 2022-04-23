# mentoring-demo
Template for the mentoring project

To run the postgres locally:

```
sh start-db-dev.sh
```

to test the API running: 
```
curl --location --request POST 'localhost:8080/api/ms/mentoring-demo/request/create' \
--header 'Content-Type: application/json' \
--data-raw '{

}'
```

verify request table and you will see a new request created