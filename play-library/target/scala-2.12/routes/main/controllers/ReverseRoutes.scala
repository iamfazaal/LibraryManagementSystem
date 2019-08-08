// @GENERATOR:play-routes-compiler
// @SOURCE:D:/University Stuffs/Level 5/Semister 1/OOP/CourseWork/play-library/conf/routes
// @DATE:Tue Jun 25 03:53:27 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:12
package controllers {

  // @LINE:12
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def addDvds(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "adddvds")
    }
  
    // @LINE:17
    def addBook(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addbook")
    }
  
    // @LINE:23
    def deleteItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delete")
    }
  
    // @LINE:21
    def borrowItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "borrow")
    }
  
    // @LINE:19
    def addreader(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addreader")
    }
  
    // @LINE:13
    def getDVDList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getdvds")
    }
  
    // @LINE:22
    def returnItem(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "return")
    }
  
    // @LINE:15
    def getReport(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getreport")
    }
  
    // @LINE:12
    def getBookList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getbooks")
    }
  
    // @LINE:14
    def getReaderList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getreaders")
    }
  
  }

  // @LINE:25
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
