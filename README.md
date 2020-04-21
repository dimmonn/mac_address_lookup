
# Mac Resolver

Mac Resolver is a tool to lookup the company name based on mac address id

## Installation

Use a maven to make a build

```bash
git clone https://github.com/dimmonn/mac_address_lookup.git
cd mac_address_lookup
mvn clean compile assembly:single
```

## Usage

```java
java -jar target/mac_address_lookup-1.0-SNAPSHOT-jar-with-dependencies.jar
```
### follow output helper
```bash
usage: mac-checker
 -m,--mac address <arg>   enter mac-address
 -p,--api key <arg>       enter api key

java -jar target/mac_address_lookup-1.0-SNAPSHOT-jar-with-dependencies.jar -p {api_key} -m 44:38:39:ff:ef:57
```

## Run with docker
1. replace placeholder api_key in Dockerfile with real api key
2. run below command
```docker
 make dev
```