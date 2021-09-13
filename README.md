# Products

## About

Products server is a spring boot application which provide secured end points to access inventory DB

## Low level design

Products server is an spring boot application which interacts with mysql DB to to perform fetch, add and update operations. It is integrated with the Keylock support for spring boot to implement OAuth security to it's exposed REST end points.

#### For API Documentation: 
*#serverUrl#*/swagger-ui.html

## Configuration

Add the properties in application.properties file as follows

        server.port=//port config
        spring.datasource.driver-class-name=//db driver class name
        spring.datasource.url=//DB url
        spring.datasource.username=// DB user
        spring.datasource.password=// DB password

        keycloak.realm                      = //Keycloak realm name
        keycloak.auth-server-url            = //keycloak auth URL
        keycloak.ssl-required               = none
        keycloak.resource                   = //Keycloak client id
        keycloak.public-client		    = true
        keycloak.realm-key		    = //Keycloak realm public key /*If not provided Keycloack will use auth url to get key in rotation mode*/

## Deploy

Follow the below steps:

1) mvn clean build to build the project.
2) Take the jar and perform java -jar <jar-file> on the server where java 11 is suported.
