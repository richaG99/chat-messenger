// @SOURCE:/Users/richa/work/chat_messager/conf/routes
// @HASH:26a9231b2e0776c5aa79d63a8ffebff8a7e9a067
// @DATE:Thu Aug 27 19:22:31 IST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:21
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
// @LINE:4
package controllers {

// @LINE:17
// @LINE:8
// @LINE:6
class ReverseMessages {


// @LINE:6
def messages(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/messaging/v1/message" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                        

// @LINE:17
def updateMessageAsRead(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "api/messaging/v1/message/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:8
def createMessage(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/messaging/v1/message")
}
                        

}
                          

// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:4
class ReverseUsers {


// @LINE:4
def userByEmailId(email_id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "api/messaging/v1/user" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("email_id", email_id)))))
}
                        

// @LINE:14
def sendMessage(id:String, rec_email_id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "api/messaging/v1/user/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/message/send" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("rec_email_id", rec_email_id)))))
}
                        

// @LINE:12
// @LINE:10
def allInboxMessage(email_id:String, isRead:Boolean): Call = {
   (email_id: @unchecked, isRead: @unchecked) match {
// @LINE:10
case (email_id, isRead)  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "api/messaging/v1/user/inbox/messages/all" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("email_id", email_id)), if(isRead == true) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("isRead", isRead)))))
                                         
   }
}
                                                

}
                          

// @LINE:21
class ReverseApplication {


// @LINE:21
def options(url:String): Call = {
   import ReverseRouteContext.empty
   Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("url", url))
}
                        

}
                          
}
                  


// @LINE:21
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
// @LINE:4
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:17
// @LINE:8
// @LINE:6
class ReverseMessages {


// @LINE:6
def messages : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Messages.messages",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/messaging/v1/message" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:17
def updateMessageAsRead : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Messages.updateMessageAsRead",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/messaging/v1/message/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:8
def createMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Messages.createMessage",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/messaging/v1/message"})
      }
   """
)
                        

}
              

// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:4
class ReverseUsers {


// @LINE:4
def userByEmailId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.userByEmailId",
   """
      function(email_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/messaging/v1/user" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email_id", email_id)])})
      }
   """
)
                        

// @LINE:14
def sendMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.sendMessage",
   """
      function(id,rec_email_id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/messaging/v1/user/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/message/send" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("rec_email_id", rec_email_id)])})
      }
   """
)
                        

// @LINE:12
// @LINE:10
def allInboxMessage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Users.allInboxMessage",
   """
      function(email_id, isRead) {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/messaging/v1/user/inbox/messages/all" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email_id", email_id), (isRead == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("isRead", isRead))])})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/messaging/v1/user/inbox/messages/unread" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email_id", email_id), (isRead == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("isRead", isRead))])})
      }
      }
   """
)
                        

}
              

// @LINE:21
class ReverseApplication {


// @LINE:21
def options : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.options",
   """
      function(url) {
      return _wA({method:"OPTIONS", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("url", url)})
      }
   """
)
                        

}
              
}
        


// @LINE:21
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
// @LINE:4
package controllers.ref {


// @LINE:17
// @LINE:8
// @LINE:6
class ReverseMessages {


// @LINE:6
def messages(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Messages.messages(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Messages", "messages", Seq(classOf[Long]), "GET", """get message info by passing message id""", _prefix + """api/messaging/v1/message""")
)
                      

// @LINE:17
def updateMessageAsRead(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Messages.updateMessageAsRead(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Messages", "updateMessageAsRead", Seq(classOf[Long]), "PUT", """update a message as read ( additional)""", _prefix + """api/messaging/v1/message/$id<[^/]+>""")
)
                      

// @LINE:8
def createMessage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Messages.createMessage(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Messages", "createMessage", Seq(), "POST", """create a message""", _prefix + """api/messaging/v1/message""")
)
                      

}
                          

// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:4
class ReverseUsers {


// @LINE:4
def userByEmailId(email_id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.userByEmailId(email_id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "userByEmailId", Seq(classOf[String]), "GET", """get user info by passing email id""", _prefix + """api/messaging/v1/user""")
)
                      

// @LINE:14
def sendMessage(id:String, rec_email_id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.sendMessage(id, rec_email_id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "sendMessage", Seq(classOf[String], classOf[String]), "POST", """get all sent messages for a user""", _prefix + """api/messaging/v1/user/$id<[^/]+>/message/send""")
)
                      

// @LINE:10
def allInboxMessage(email_id:String, isRead:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Users.allInboxMessage(email_id, isRead), HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "allInboxMessage", Seq(classOf[String], classOf[Boolean]), "GET", """get all messages for a user inbox""", _prefix + """api/messaging/v1/user/inbox/messages/all""")
)
                      

}
                          

// @LINE:21
class ReverseApplication {


// @LINE:21
def options(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.options(url), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "options", Seq(classOf[String]), "OPTIONS", """Used to enable CORS""", _prefix + """$url<.+>""")
)
                      

}
                          
}
        
    