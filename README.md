
Create app
```bash
mvn io.quarkus:quarkus-maven-plugin:1.0.1.Final:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=getting-started \
    -DclassName="org.acme.quickstart.GreetingResource" \
    -Dpath="/hello"
cd getting-started
```
Add extension
```bash
mvn quarkus:add-extensions -Dextensions=spring-di
```

## Run

```bash
mvn compile quarkus:dev
```


Native image:
https://quarkus.io/guides/building-native-image

```bash
mvn package -Pnative
```
test native
```bash
mvn verify -Pnative
```

Test with 'httpie'

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

Native image limitation
https://github.com/oracle/graal/blob/master/substratevm/LIMITATIONS.md

Quarkus tips for native images
https://quarkus.io/guides/writing-native-applications-tips
