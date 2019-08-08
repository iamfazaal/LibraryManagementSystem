// @GENERATOR:play-routes-compiler
// @SOURCE:D:/University Stuffs/Level 5/Semister 1/OOP/CourseWork/play-library/conf/routes
// @DATE:Tue Jun 25 03:53:27 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:12
  HomeController_0: controllers.HomeController,
  // @LINE:25
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:12
    HomeController_0: controllers.HomeController,
    // @LINE:25
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getbooks""", """controllers.HomeController.getBookList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getdvds""", """controllers.HomeController.getDVDList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getreaders""", """controllers.HomeController.getReaderList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getreport""", """controllers.HomeController.getReport"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addbook""", """controllers.HomeController.addBook"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """adddvds""", """controllers.HomeController.addDvds"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addreader""", """controllers.HomeController.addreader"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """borrow""", """controllers.HomeController.borrowItem"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """return""", """controllers.HomeController.returnItem"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete""", """controllers.HomeController.deleteItem"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:12
  private[this] lazy val controllers_HomeController_getBookList0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getbooks")))
  )
  private[this] lazy val controllers_HomeController_getBookList0_invoker = createInvoker(
    HomeController_0.getBookList,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getBookList",
      Nil,
      "GET",
      this.prefix + """getbooks""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_getDVDList1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getdvds")))
  )
  private[this] lazy val controllers_HomeController_getDVDList1_invoker = createInvoker(
    HomeController_0.getDVDList,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getDVDList",
      Nil,
      "GET",
      this.prefix + """getdvds""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_getReaderList2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getreaders")))
  )
  private[this] lazy val controllers_HomeController_getReaderList2_invoker = createInvoker(
    HomeController_0.getReaderList,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getReaderList",
      Nil,
      "GET",
      this.prefix + """getreaders""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_getReport3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getreport")))
  )
  private[this] lazy val controllers_HomeController_getReport3_invoker = createInvoker(
    HomeController_0.getReport,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getReport",
      Nil,
      "GET",
      this.prefix + """getreport""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_HomeController_addBook4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addbook")))
  )
  private[this] lazy val controllers_HomeController_addBook4_invoker = createInvoker(
    HomeController_0.addBook,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addBook",
      Nil,
      "POST",
      this.prefix + """addbook""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_addDvds5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("adddvds")))
  )
  private[this] lazy val controllers_HomeController_addDvds5_invoker = createInvoker(
    HomeController_0.addDvds,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addDvds",
      Nil,
      "POST",
      this.prefix + """adddvds""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_HomeController_addreader6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addreader")))
  )
  private[this] lazy val controllers_HomeController_addreader6_invoker = createInvoker(
    HomeController_0.addreader,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addreader",
      Nil,
      "POST",
      this.prefix + """addreader""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_HomeController_borrowItem7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("borrow")))
  )
  private[this] lazy val controllers_HomeController_borrowItem7_invoker = createInvoker(
    HomeController_0.borrowItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "borrowItem",
      Nil,
      "POST",
      this.prefix + """borrow""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_HomeController_returnItem8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("return")))
  )
  private[this] lazy val controllers_HomeController_returnItem8_invoker = createInvoker(
    HomeController_0.returnItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "returnItem",
      Nil,
      "POST",
      this.prefix + """return""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_HomeController_deleteItem9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete")))
  )
  private[this] lazy val controllers_HomeController_deleteItem9_invoker = createInvoker(
    HomeController_0.deleteItem,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteItem",
      Nil,
      "POST",
      this.prefix + """delete""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:12
    case controllers_HomeController_getBookList0_route(params@_) =>
      call { 
        controllers_HomeController_getBookList0_invoker.call(HomeController_0.getBookList)
      }
  
    // @LINE:13
    case controllers_HomeController_getDVDList1_route(params@_) =>
      call { 
        controllers_HomeController_getDVDList1_invoker.call(HomeController_0.getDVDList)
      }
  
    // @LINE:14
    case controllers_HomeController_getReaderList2_route(params@_) =>
      call { 
        controllers_HomeController_getReaderList2_invoker.call(HomeController_0.getReaderList)
      }
  
    // @LINE:15
    case controllers_HomeController_getReport3_route(params@_) =>
      call { 
        controllers_HomeController_getReport3_invoker.call(HomeController_0.getReport)
      }
  
    // @LINE:17
    case controllers_HomeController_addBook4_route(params@_) =>
      call { 
        controllers_HomeController_addBook4_invoker.call(HomeController_0.addBook)
      }
  
    // @LINE:18
    case controllers_HomeController_addDvds5_route(params@_) =>
      call { 
        controllers_HomeController_addDvds5_invoker.call(HomeController_0.addDvds)
      }
  
    // @LINE:19
    case controllers_HomeController_addreader6_route(params@_) =>
      call { 
        controllers_HomeController_addreader6_invoker.call(HomeController_0.addreader)
      }
  
    // @LINE:21
    case controllers_HomeController_borrowItem7_route(params@_) =>
      call { 
        controllers_HomeController_borrowItem7_invoker.call(HomeController_0.borrowItem)
      }
  
    // @LINE:22
    case controllers_HomeController_returnItem8_route(params@_) =>
      call { 
        controllers_HomeController_returnItem8_invoker.call(HomeController_0.returnItem)
      }
  
    // @LINE:23
    case controllers_HomeController_deleteItem9_route(params@_) =>
      call { 
        controllers_HomeController_deleteItem9_invoker.call(HomeController_0.deleteItem)
      }
  
    // @LINE:25
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
