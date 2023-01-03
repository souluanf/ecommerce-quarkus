# Ecommerce Quarkus (Applicação e README em construção...)

### Microservices(apis):
- Customer
- Product
- Order
- Keycloak Server

### Stack
- [Quarkus](https://quarkus.io): A Kubernetes Native Java stack tailored for OpenJDK HotSpot and GraalVM, crafted from the best of breed Java libraries and standards.
- [GraalVm for Java17](https://www.graalvm.org/java): High-performance runtime with new compiler optimizations to accelerate Java application performance and lower infrastructure costs on premises and in the cloud.
- [Gradle](https://gradle.org): Accelerate developer productivity.
- [Hibernate ORM with Panache](https://quarkus.io/guides/hibernate-orm-panache): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern.
- [JDBC Driver - PostgreSQL](https://quarkus.io/guides/datasource): Connect to the PostgreSQL database via JDBC.
- [RESTEasy Reactive](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources): Easily start your Reactive RESTful Web Services.
- [Docker](https://www.docker.com): Develop faster. Run anywhere.

## Running the application in dev mode

### Databases and Keycloak

```shell
docker-compose -f docker-compose.yml -p ecommerce-quarkus up -d
```

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:APP_PORT/q/dev/.

## Packaging and running the application

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/APPNAME-quarkus-1.0.0-SNAPSHOT-runner`

