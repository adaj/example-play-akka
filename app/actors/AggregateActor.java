package actors;

import akka.actor.*;
import java.util.*;
import messages.*;

public class AggregateActor extends AbstractActor {

  private String queryString = "";

  @Override
  public Receive createReceive() {
    return receiveBuilder()//
                .match(String.class, s -> {
                  queryString += s+", ";
                })
                .match(ResultRequest.class, s-> {
                  getSender().tell(queryString, self());
                })
                .build();
  }

  public static Props props() {
		return Props.create(AggregateActor.class);
	}

}
