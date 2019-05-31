package actors;

import akka.actor.*;

public class HelloActor extends AbstractActor {

    static public Props props(String message) {
      return Props.create(HelloActor.class);
    }

		@Override
		public Receive createReceive() {
			return receiveBuilder()//
	                .match(String.class, s -> {
										sender().tell(s+", I'm an actor!", self());
									})
									.build();
		}
}
