# Example-Play-Akka

Hi! This is a "hello-world" template to use [Play](https://www.playframework.com) and [Akka](https://akka.io/docs/) with Java, and also be able to develop in Eclipse.

Feel free to fork this project, but in order for you to use it, you will need to [install sbt](https://www.scala-sbt.org/download.html).

NEW! This project also set a Cassandra database to illustrate how it can easily be integrated. To install Cassandra, please follow the instructions on `installing_cassandra.md` file in this repository.

NEW! We added the Spark integration to this project. You need to follow the instructions on `installing_spark.md` to download it properly.

To make everything ready for development using Eclipse, you'll still have to run the following commands in the root directory of this repository.

    sbt
    eclipse
    run

This make take a while. After it, try to access localhost:9000 in your browser, and the routes available `/hello` and `/hi/yourName`. To test Cassandra connection, you should access the route `/requestinfo/0` and see some `test_name`. 

In this project, you can see how to use multiple actors to query a Cassandra table. Besides following the instructions on `installing_cassandra.md`, insert 5 more keys with respective names in order to see the result in the `/selectall` route.

To import the project to Eclipse, click File>Import>Gradle>Existing Gradle Project>Next>Browse [the repository folder]>Finish.
