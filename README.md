## Run

```bash
mvn compile quarkus:dev
```

Then with 'httpie'

```bash
http :8080
# Empty list
http POST :8080 name=a
# Check returned URL
http $URL
# Update
http PATH $URL name=a2
# Create another one
http POST :8080 name=b
# List all
http :8080
# Delete one
http DELETE $URL
# List all
http :8080
```

