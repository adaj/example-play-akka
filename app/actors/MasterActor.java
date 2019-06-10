package actors;

import akka.actor.*;
import akka.routing.*;
import akka.japi.pf.DeciderBuilder;
import static akka.actor.SupervisorStrategy.*;
import scala.concurrent.duration.Duration;
import messages.*;
import java.util.*;

public class MasterActor extends AbstractActor {

  static public Props props() {
    return Props.create(MasterActor.class);
  }

  final SupervisorStrategy routingSupervisorStrategy =
    new OneForOneStrategy(
      10,
      Duration.create("10 seconds"),
      DeciderBuilder
          .match(RuntimeException.class, ex -> restart())
          .build()
    );

  // ActorRef router = getContext().actorOf(new RoundRobinPool(2)
  //                       .withSupervisorStrategy(routingSupervisorStrategy)
  //                       .props(HelloActor.props()), "router");

  Router router;
  {
    List<Routee> routees = new ArrayList<Routee>();
    for (int i = 0; i < 10; i++) {
      ActorRef r = getContext().actorOf(Props.create(DbActor.class));
      getContext().watch(r);
      routees.add(new ActorRefRoutee(r));
    }
    router = new Router(new RoundRobinRoutingLogic(), routees);
  }

  ActorRef aggregateActor = getContext().actorOf(AggregateActor.props());

  @Override
  public Receive createReceive() {
      return receiveBuilder()//
                  .match(MsgQuery.class, s -> {
                    for (int i=0; i < s.getN(); i++) {
                        router.route(i, getSender()); 
                    }
                  })
                  .match(String.class, s -> {
                    aggregateActor.tell(s, self());
                  })
                  .match(ResultRequest.class, s -> {
                    aggregateActor.forward(s, getContext());
                  })
                  .build();
  }

}
