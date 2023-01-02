# API Framework - REST API testing with Serenity and Cucumber

### The project directory structure
The project has build scripts for both Maven and follows the standard directory structure used in most Serenity projects:

```Gherkin
src
  + main
  + test
    + java                                               Test runners and supporting code
        + com.api.petstore.application.test.pojo         Pojo classes for request
        + com.api.petstore.application.test.runner       Runner class for running Test Cases based on tag
        + com.api.petstore.application.test.steps        Created Steps for passing request and validating response
        + com.api.petstore.application.test.util         Common Method & Endpoint details 
    + resources
      + features                          Feature files 
        + CreateAirline.feature
        + GetAirline.feature
      + config.properties                         Passed endpoint and path parameter                

```

## Command to run

You can generate full Serenity reports by running `mvn clean verify`. 
For running Smoke Test Cases:- `mvn clean verify -Dcucumber.filter.tags=@Smoke`.
For running Regression Test Cases:- `mvn clean verify -Dcucumber.filter.tags=@Regression`.
Report will be generated in directory:- Serenity-rest-cucumber\target\site\serenity\index.html


