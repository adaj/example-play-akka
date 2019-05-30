// @GENERATOR:play-routes-compiler
// @SOURCE:/home/adelsondias/Repos/example-play-akka/conf/routes
// @DATE:Thu May 30 16:32:49 BRT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
