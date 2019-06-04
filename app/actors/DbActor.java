package actors;

import akka.actor.*;
import messages.*;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import java.util.Iterator;


public class DbActor extends AbstractActor {

    private Cluster cluster;
	  private Session session;
    public DbActor() {
  		  cluster = Cluster.builder().addContactPoint("127.0.0.1").withCredentials("cassandra", "cassandra").build();
        Metadata metadata = cluster.getMetadata();

        System.out.printf("@@@@@@@Connected to cluster: %s\n",
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

    static public Props props() {
      return Props.create(DbActor.class);
    }

		@Override
		public Receive createReceive() {
			return receiveBuilder()
                  .match(MsgQuery.class, s -> {
                    sender().tell(queryUser(s), self());
                  })
									.build();
		}

}
