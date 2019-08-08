// @GENERATOR:play-routes-compiler
// @SOURCE:D:/University Stuffs/Level 5/Semister 1/OOP/CourseWork/play-library/conf/routes
// @DATE:Tue Jun 25 03:53:27 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:12
package controllers.javascript {

  // @LINE:12
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def addDvds: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addDvds",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "adddvds"})
        }
      """
    )
  
    // @LINE:17
    def addBook: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addBook",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addbook"})
        }
      """
    )
  
    // @LINE:23
    def deleteItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete"})
        }
      """
    )
  
    // @LINE:21
    def borrowItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.borrowItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "borrow"})
        }
      """
    )
  
    // @LINE:19
    def addreader: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addreader",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addreader"})
        }
      """
    )
  
    // @LINE:13
    def getDVDList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getDVDList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getdvds"})
        }
      """
    )
  
    // @LINE:22
    def returnItem: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.returnItem",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "return"})
        }
      """
    )
  
    // @LINE:15
    def getReport: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getReport",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getreport"})
        }
      """
    )
  
    // @LINE:12
    def getBookList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getBookList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getbooks"})
        }
      """
    )
  
    // @LINE:14
    def getReaderList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getReaderList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getreaders"})
        }
      """
    )
  
  }

  // @LINE:25
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
