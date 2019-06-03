package actors;

import akka.actor.*;
import messages.*;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.util.Iterator;

public class HelloActor extends AbstractActor {

    private Cluster cluster;
	  private Session session;
    public HelloActor() {
  		  cluster = Cluster.builder().addContactPoint("127.0.0.1").withCredentials("cassandra", "cassandra").build();
        System.out.println("@@@@@@@@@@@@\nCassandra connection established");
        Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n",
                metadata.getClusterName());
        session = cluster.connect("example_play");
  	}

    public String queryUser(MsgQuery query) {
        ResultSet results = session.execute("SELECT * FROM users WHERE id = " + query.getUser());
        String line = "";
        for (Iterator<Row> iterator = results.iterator(); iterator.hasNext();) {
            Row row = iterator.next();
            line += row.getString("nome") + "\n";
        }
        return line;
    }

    static public Props props(String message) {
      return Props.create(HelloActor.class);
    }

		@Override
		public Receive createReceive() {
			return receiveBuilder()//
	                .match(String.class, s -> {
										sender().tell(s+", I'm an actor!", self());
									})
                  .match(MsgQuery.class, s -> {
                    sender().tell(queryUser(s), self());
                  })
									.build();
		}
}
