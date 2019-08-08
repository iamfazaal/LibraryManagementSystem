// @GENERATOR:play-routes-compiler
// @SOURCE:D:/University Stuffs/Level 5/Semister 1/OOP/CourseWork/play-library/conf/routes
// @DATE:Tue Jun 25 03:53:27 IST 2019


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
