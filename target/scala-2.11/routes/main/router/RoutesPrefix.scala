// @GENERATOR:play-routes-compiler
// @SOURCE:/home/adelsondias/Repos/example-play-akka/conf/routes
// @DATE:Fri May 31 11:11:35 BRT 2019


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
