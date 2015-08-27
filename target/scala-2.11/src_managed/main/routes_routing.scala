// @SOURCE:/Users/richa/work/chat_messager/conf/routes
// @HASH:26a9231b2e0776c5aa79d63a8ffebff8a7e9a067
// @DATE:Thu Aug 27 19:22:31 IST 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:4
private[this] lazy val controllers_Users_userByEmailId0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/messaging/v1/user"))))
private[this] lazy val controllers_Users_userByEmailId0_invoker = createInvoker(
controllers.Users.userByEmailId(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "userByEmailId", Seq(classOf[String]),"GET", """get user info by passing email id""", Routes.prefix + """api/messaging/v1/user"""))
        

// @LINE:6
private[this] lazy val controllers_Messages_messages1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/messaging/v1/message"))))
private[this] lazy val controllers_Messages_messages1_invoker = createInvoker(
controllers.Messages.messages(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Messages", "messages", Seq(classOf[Long]),"GET", """get message info by passing message id""", Routes.prefix + """api/messaging/v1/message"""))
        

// @LINE:8
private[this] lazy val controllers_Messages_createMessage2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/messaging/v1/message"))))
private[this] lazy val controllers_Messages_createMessage2_invoker = createInvoker(
controllers.Messages.createMessage,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Messages", "createMessage", Nil,"POST", """create a message""", Routes.prefix + """api/messaging/v1/message"""))
        

// @LINE:10
private[this] lazy val controllers_Users_allInboxMessage3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/messaging/v1/user/inbox/messages/all"))))
private[this] lazy val controllers_Users_allInboxMessage3_invoker = createInvoker(
controllers.Users.allInboxMessage(fakeValue[String], fakeValue[Boolean]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "allInboxMessage", Seq(classOf[String], classOf[Boolean]),"GET", """get all messages for a user inbox""", Routes.prefix + """api/messaging/v1/user/inbox/messages/all"""))
        

// @LINE:12
private[this] lazy val controllers_Users_allInboxMessage4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/messaging/v1/user/inbox/messages/unread"))))
private[this] lazy val controllers_Users_allInboxMessage4_invoker = createInvoker(
controllers.Users.allInboxMessage(fakeValue[String], fakeValue[Boolean]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "allInboxMessage", Seq(classOf[String], classOf[Boolean]),"GET", """get all unread messages for a user inbox""", Routes.prefix + """api/messaging/v1/user/inbox/messages/unread"""))
        

// @LINE:14
private[this] lazy val controllers_Users_sendMessage5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/messaging/v1/user/"),DynamicPart("id", """[^/]+""",true),StaticPart("/message/send"))))
private[this] lazy val controllers_Users_sendMessage5_invoker = createInvoker(
controllers.Users.sendMessage(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Users", "sendMessage", Seq(classOf[String], classOf[String]),"POST", """get all sent messages for a user""", Routes.prefix + """api/messaging/v1/user/$id<[^/]+>/message/send"""))
        

// @LINE:17
private[this] lazy val controllers_Messages_updateMessageAsRead6_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/messaging/v1/message/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Messages_updateMessageAsRead6_invoker = createInvoker(
controllers.Messages.updateMessageAsRead(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Messages", "updateMessageAsRead", Seq(classOf[Long]),"PUT", """update a message as read ( additional)""", Routes.prefix + """api/messaging/v1/message/$id<[^/]+>"""))
        

// @LINE:21
private[this] lazy val controllers_Application_options7_route = Route("OPTIONS", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("url", """.+""",false))))
private[this] lazy val controllers_Application_options7_invoker = createInvoker(
controllers.Application.options(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "options", Seq(classOf[String]),"OPTIONS", """Used to enable CORS""", Routes.prefix + """$url<.+>"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/messaging/v1/user""","""controllers.Users.userByEmailId(email_id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/messaging/v1/message""","""controllers.Messages.messages(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/messaging/v1/message""","""controllers.Messages.createMessage"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/messaging/v1/user/inbox/messages/all""","""controllers.Users.allInboxMessage(email_id:String, isRead:Boolean ?= true)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/messaging/v1/user/inbox/messages/unread""","""controllers.Users.allInboxMessage(email_id:String, isRead:Boolean ?= false)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/messaging/v1/user/$id<[^/]+>/message/send""","""controllers.Users.sendMessage(id:String, rec_email_id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/messaging/v1/message/$id<[^/]+>""","""controllers.Messages.updateMessageAsRead(id:Long)"""),("""OPTIONS""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$url<.+>""","""controllers.Application.options(url:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:4
case controllers_Users_userByEmailId0_route(params) => {
   call(params.fromQuery[String]("email_id", None)) { (email_id) =>
        controllers_Users_userByEmailId0_invoker.call(controllers.Users.userByEmailId(email_id))
   }
}
        

// @LINE:6
case controllers_Messages_messages1_route(params) => {
   call(params.fromQuery[Long]("id", None)) { (id) =>
        controllers_Messages_messages1_invoker.call(controllers.Messages.messages(id))
   }
}
        

// @LINE:8
case controllers_Messages_createMessage2_route(params) => {
   call { 
        controllers_Messages_createMessage2_invoker.call(controllers.Messages.createMessage)
   }
}
        

// @LINE:10
case controllers_Users_allInboxMessage3_route(params) => {
   call(params.fromQuery[String]("email_id", None), params.fromQuery[Boolean]("isRead", Some(true))) { (email_id, isRead) =>
        controllers_Users_allInboxMessage3_invoker.call(controllers.Users.allInboxMessage(email_id, isRead))
   }
}
        

// @LINE:12
case controllers_Users_allInboxMessage4_route(params) => {
   call(params.fromQuery[String]("email_id", None), params.fromQuery[Boolean]("isRead", Some(false))) { (email_id, isRead) =>
        controllers_Users_allInboxMessage4_invoker.call(controllers.Users.allInboxMessage(email_id, isRead))
   }
}
        

// @LINE:14
case controllers_Users_sendMessage5_route(params) => {
   call(params.fromPath[String]("id", None), params.fromQuery[String]("rec_email_id", None)) { (id, rec_email_id) =>
        controllers_Users_sendMessage5_invoker.call(controllers.Users.sendMessage(id, rec_email_id))
   }
}
        

// @LINE:17
case controllers_Messages_updateMessageAsRead6_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Messages_updateMessageAsRead6_invoker.call(controllers.Messages.updateMessageAsRead(id))
   }
}
        

// @LINE:21
case controllers_Application_options7_route(params) => {
   call(params.fromPath[String]("url", None)) { (url) =>
        controllers_Application_options7_invoker.call(controllers.Application.options(url))
   }
}
        
}

}
     