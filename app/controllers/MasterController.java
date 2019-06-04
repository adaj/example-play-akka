package controllers;

import akka.actor.*;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import javax.inject.*;
import java.util.concurrent.CompletionStage;
import actors.*;
import messages.*;
import static akka.pattern.Patterns.ask;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class MasterController extends Controller {

  final ActorSystem actorSystem = ActorSystem.create("playakka");
  final ActorRef masterActor = actorSystem.actorOf(MasterActor.props());

  public CompletionStage<Result> selectAll() {
        masterActor.tell(new MsgQuery(5), masterActor);
        return FutureConverters.toJava(
            ask(masterActor, new ResultRequest(), 2000))
                .thenApply(response -> ok(views.html.actor.render(response.toString())));
  }

}
