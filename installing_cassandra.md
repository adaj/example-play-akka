
## a. To install and start Cassandra

1.1 - sudo update-alternatives --config java   # change java to java 8!

1.2 - sudo update-alternatives --config javac  # change javac to javac 8!

2 - Download: http://www.apache.org/dyn/closer.lua/cassandra/3.11.4/apache-cassandra-3.11.4-bin.tar.gz

3 - On cassandra.yaml, edit authenticator to "authenticator: PasswordAuthenticator" and authorizer to "authorizer: CassandraAuthorizer"

4 - bin/cassandra -f # to start cassandra service

5 - bin/cqlsh -u cassandra -p cassandra # to start cassandra terminal


## b. To create a keyspace and a table for this project

6 - cqlsh> CREATE KEYSPACE example_play WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

7 - cqlsh> USE example_play;

8 - cqlsh> CREATE TABLE users (id int PRIMARY KEY, nome varchar, time timestamp);

9 - cqlsh> INSERT INTO users (id, nome) VALUES (0, 'test_name');

10 - cqlsh> SELECT * FROM users;
