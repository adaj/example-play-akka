# Example-Play-Akka

Hello! This is a template to use [Play](https://www.playframework.com) and [Akka](https://akka.io/docs/) with Java, and also be able to develop in Eclipse.

Feel free to fork this project, but in order for you to use it, you will need to [install sbt](https://www.scala-sbt.org/download.html).

To make everything ready for development with Play and Akka in Eclipse, you'll still have to run the following commands in the root directory of this repository.

    sbt
    eclipse
    run

This make take a while. After it, try to access localhost:9000 in your browser, and the routes available /hello and /hi/yourName.

To import the project to Eclipse, click File>Import>Gradle>Existing Gradle Project>Next>Browse [the repository folder]>Finish.
