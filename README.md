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

