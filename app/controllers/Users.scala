package controllers


import models.ChatUser
import org.joda.time.DateTime
import play.api.Logger
import play.api.db.slick.{DBAction, _}
import play.api.libs.json.Json
import play.api.mvc.Controller
import utils.DBUtils

import v2.service.{MessageServiceObject, UserMessageServiceObject, ChatUserServiceObject}
import helpers.ResultHelper._

/**
 * Created by richa on 22/08/15.
 */
object Users extends Controller {

  implicit val context = play.api.libs.concurrent.Execution.Implicits.defaultContext

  val logger:Logger = Logger(this.getClass)



  def userByEmailId(email_id: String) = DBAction { implicit rs =>
    try {
       val ts = DateTime.now.getMillis
       val user = ChatUserServiceObject.findByEmailId(email_id)
       Logger.debug(utils.LogMsgUtils.dbTimeLogMsgMS(DateTime.now.getMillis - ts, "dataapi.users.findUserByEmailId"))
        if (user.isEmpty)
           notFound("User with email id not found")
        else
          ok(Json.toJson(Some(user)), s"user info with email id $email_id")
    } catch {
      case e: Exception =>
        logger.error("Error getting user with email id: "+ email_id,e)
        internalServerError(Application.CHECK_LOGS_MSG)
    }
  }

  def allInboxMessage(email_id: String, is_read: Boolean) = DBAction { implicit rs =>
    try {
      val ts = DateTime.now.getMillis

      val user = ChatUserServiceObject.findByEmailId(email_id)
      if (user.isEmpty)
        notFound("User with email id not found")
      else {
        val messageList = if(is_read) UserMessageServiceObject.allInboxMessagesForUser(user.get.id)  else  UserMessageServiceObject.unreadInboxMessagesForUser(user.get.id)
        ok(Json.toJson(messageList), s"messages for user with email id $email_id")
      }
    } catch {
      case e: Exception =>
        logger.error(s" Eror in getting Messages fore user with email id $email_id.")
        internalServerError(Application.CHECK_LOGS_MSG)
    }
  }

  def sendMessage(id:String, rec_email_id: String) = DBAction(DBUtils.DB_DEFAULT, parse.json) { implicit request =>
    try {
      val msgBody = request.body.as[models.MessageRead]

      val userObjList : List[ChatUser] = ChatUserServiceObject.findUsersByEmailIdList(List(id, rec_email_id))
      if(userObjList.size != 2)
        notFound("either sender or receiver email id is not vaild")

      else{
        val senderUser: Option[ChatUser] = userObjList.find(x => x.email_id.equals(id))
        val receiverUser: Option[ChatUser] = userObjList.find(x => x.email_id.equals(rec_email_id))

        senderUser match {
          case None => notFound(s"sender with email id $id is not found")
          case sender => sender
        }

        receiverUser match {
          case None => notFound( s"receiver with email id $rec_email_id is not found")
          case receiver => receiver
        }
        // inserting message in message table
        val msgId = MessageServiceObject.createMessage(msgBody)

        if(msgId > 0){
          // making entry for sent message in user_message table
        val userMsgId = UserMessageServiceObject.createUserMessage(msgId, senderUser.get.id, receiverUser.get.id)
         if(userMsgId > 0)
          ok(Json.toJson("success"), s"message  with message id $msgId is sent from user email id $id to $rec_email_id ")
         else
           notFound(s"error is sending message from email id $id to $rec_email_id")

        } else{
          notFound("Us with id not found")
        }
      }

    } catch {
      case e: Exception =>
        logger.error("Error in creating message  ", e)
        internalServerError(Application.CHECK_LOGS_MSG)
    }
  }
}
