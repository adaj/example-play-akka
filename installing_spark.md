## a. To install and start Spark

1. Install and extract spark 

2. Start a master with `./spark_folder/sbin/start-master.sh`

3. Test to access `http://localhost:8080`

4. Start a worker node with `sbin/start-slave.sh spark://your_machine:7077`. If your don't know what is the name of your machine, see on localhost:8000 at the top of the page "Spark Master at spark://your_machine:7077" 

5. Now that you have a worker, you can run your code using this infrastructure. If you want to configure your infrastructure, we refer to Spark docs.


