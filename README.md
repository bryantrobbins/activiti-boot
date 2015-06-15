# What?

I'm playing around with Activiti and Spring Boot.

I'm starting from this tutorial:
https://spring.io/blog/2015/03/08/getting-started-with-activiti-and-spring-boot

I might add some additional features or change things up a
bit as I go. Feel free to follow along.

# Development Log

## Initial Commit

I just wrote a README.

## Starter Project

I used Spring Initializr (https://start.spring.io/) to create a Gradle Project with H2 and Actuator built in, and specified the Maven repo coordinates and other metadata. I'm a big fan of this tool.

I've added the contents of my zip from Initializr to this commit.

## Gitignore

I've added a basic .gitignore file to the project. I use examples from https://github.com/github/gitignore to
build something that makes sense for my tool stack (Gradle + Intellij).

## Package name

Having to change the package name, because I'm an idiot and used a "-" in one ...

## Rolling back Spring Boot dependency

Acitiviti only works with a bit older version(s) of Spring Boot. I've rolled my starter dependency
version back to 1.12. The application can be built and run now:

```
gradle build
java -jar build/libs/aboot-0.0.1-SNAPSHOT.jar
```

Of course, it doesn't really do anything.

## Added sample process definition

I've continued through the tutorial to add the sample "Hire Process" process definition. One thing
that is not very clear in the tutorial is where each of the pieces (the CommandLineRunner init and the
ResumeService need to be defined.

For now, I have put both into the AbootApplication.groovy file (the ResumeService as a class, and the
init method as a method).

## REST API, for the WIN

I've added the REST API for Activiti thanks to a single dependency in my gradle build file. Now I can start
and otherwise manage workflow instances from curl commands. This is awesome ... it was pretty straightforward
from the existing tutorial to do so.

## Wrapped in REST Controller, Code Cleanup

Still proceeding with the tutorial, I've created a REST Controller which I called "HiringController"
to wrap operations around the workflow. Now we actually have persistence and controllers integrated with
Activiti to provide a toy Web service. I'm pretty impressed at how little custom coding this took!

This basically ends the original tutorial, so now I'll do some of my own stuff:
* Create REST endpoints which set values on workflows
* Add REST endpoints around creation of Applicants or equivalent domain objects
* Harden auth up with LDAP
* Deal with Java errors in service tasks as conditionals for workflow
