# Products

## About

Products server is a spring boot application which provide secured end points to access inventory DB

## Low level design

Products server is an spring boot application which interacts with mysql DB to to perform fetch, add and update operations. It is integrated with the Keylock support for spring boot to implement OAuth security to it's exposed REST end points.

#### For API Documentation: 
*#productServerUrl#*/swagger-ui.html

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
        
## Demo
        
Product server url: http://ec2-13-233-27-37.ap-south-1.compute.amazonaws.com:8090
        
Keycloak server url: http://ec2-15-206-187-78.ap-south-1.compute.amazonaws.com/auth
        
*Note: Demo deployed with no SLA's to worry. Therfore, you may find some inconvenience while accessing. In that case, if you want to have a look, just ping me and we will figure it out*
