// @GENERATOR:play-routes-compiler
// @SOURCE:/home/adelsondias/Repos/example-play-akka/conf/routes
// @DATE:Fri May 31 11:11:35 BRT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
