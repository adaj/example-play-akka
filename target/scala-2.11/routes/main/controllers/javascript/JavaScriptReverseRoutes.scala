// @GENERATOR:play-routes-compiler
// @SOURCE:/home/adelsondias/Repos/example-play-akka/conf/routes
// @DATE:Fri May 31 11:11:35 BRT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def sayHi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sayHi",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hi/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0)})
        }
      """
    )
  
    // @LINE:7
    def sayHello: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.sayHello",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
