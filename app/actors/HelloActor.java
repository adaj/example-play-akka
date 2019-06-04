package actors;

import akka.actor.*;

public class HelloActor extends AbstractActor {

    public HelloActor() {
  	}

    static public Props props() {
      return Props.create(HelloActor.class);
    }

		@Override
		public Receive createReceive() {
			return receiveBuilder()//
	                .match(String.class, s -> {
										sender().tell(s+", I'm an actor!", self());
									})
                  .match(Integer.class, s -> {
                    sender().tell(s+", I'm an actor!", self());
                  })
									.build();
		}
}
