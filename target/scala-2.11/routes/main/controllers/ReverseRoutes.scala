// @GENERATOR:play-routes-compiler
// @SOURCE:/home/adelsondias/Repos/example-play-akka/conf/routes
// @DATE:Mon Jun 03 18:19:55 BRT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def requestUser(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "requestinfo/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:8
    def sayHi(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hi/" + implicitly[play.api.mvc.PathBindable[String]].unbind("name", name))
    }
  
    // @LINE:7
    def sayHello(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "hello")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
